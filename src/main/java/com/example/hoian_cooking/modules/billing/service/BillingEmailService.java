package com.example.hoian_cooking.modules.billing.service;

import com.example.hoian_cooking.modules.billing.config.BillingProperties;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillingEmailService {

    private final JavaMailSender mailSender;
    private final BillingProperties billingProperties;

    @Value("${spring.mail.username:}")
    private String defaultSenderEmail;

    public boolean sendHostingFeeReminder(String targetEmail) {
        String recipient = StringUtils.hasText(targetEmail) ? targetEmail : billingProperties.getClientEmail();

        if (!StringUtils.hasText(recipient) || recipient.equalsIgnoreCase("client@example.com")) {
            log.warn("Invalid or missing client email (recipient: {}). Please configure BILLING_CLIENT_EMAIL.",
                    recipient);
            return false;
        }

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            String sender = StringUtils.hasText(billingProperties.getFromEmail())
                    ? billingProperties.getFromEmail()
                    : defaultSenderEmail;

            if (StringUtils.hasText(sender)) {
                try {
                    helper.setFrom(sender, billingProperties.getSenderName());
                } catch (UnsupportedEncodingException e) {
                    helper.setFrom(sender);
                }
            }

            helper.setTo(recipient);

            LocalDate now = LocalDate.now();
            String currentMonthYear = now.format(DateTimeFormatter.ofPattern("MM/yyyy"));
            String subject = String.format("[Hoi An Cooking] Monthly Server Hosting Fee Notice - %s", currentMonthYear);
            helper.setSubject(subject);

            // Check and load QR image resource
            Resource qrResource = resolveQrImageResource();
            boolean hasQrImage = qrResource != null && qrResource.exists();

            String htmlBody = buildHtmlEmailContent(currentMonthYear, hasQrImage);
            helper.setText(htmlBody, true);

            // Attach inline QR image if file exists
            if (hasQrImage) {
                helper.addInline("paymentQrImage", qrResource, "image/jpeg");
                helper.addAttachment("Payment-QR-MBBank.jpg", qrResource);
                log.info("Attached QR code image from: {}", billingProperties.getQrImagePath());
            } else {
                log.warn("QR code image not found at '{}'. Sending email without inline image.",
                        billingProperties.getQrImagePath());
            }

            mailSender.send(message);
            log.info("Hosting fee reminder email sent successfully to: {}", recipient);
            return true;

        } catch (MessagingException e) {
            log.error("MessagingException when sending hosting reminder email to {}: {}", recipient, e.getMessage(), e);
            return false;
        } catch (Exception e) {
            log.error("Unexpected error occurred while sending billing email: {}", e.getMessage(), e);
            return false;
        }
    }

    /**
     * Resolve QR image resource by priority:
     * 1. Classpath (resources)
     * 2. Direct File System path
     */
    private Resource resolveQrImageResource() {
        String path = billingProperties.getQrImagePath();
        if (!StringUtils.hasText(path)) {
            return null;
        }

        // 1. Check ClassPath
        Resource classPathResource = new ClassPathResource(path);
        if (classPathResource.exists()) {
            return classPathResource;
        }

        // 2. Check File System
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return new FileSystemResource(file);
        }

        return null;
    }

    /**
     * Build HTML content for hosting fee payment reminder email in English
     */
    private String buildHtmlEmailContent(String monthYear, boolean hasQrImage) {
        String qrImageSection = hasQrImage
                ? """
                        <div style="text-align: center; margin: 24px 0; padding: 16px; background-color: #ffffff; border: 1px solid #e5e7eb; border-radius: 12px; display: inline-block;">
                            <img src="cid:paymentQrImage" alt="MBBank Payment QR Code" style="max-width: 260px; width: 100%; height: auto; border-radius: 8px; display: block; margin: 0 auto;" />
                            <p style="margin: 8px 0 0 0; font-size: 13px; color: #6b7280; font-style: italic;">Scan QR code with your mobile banking app to pay</p>
                        </div>
                        """
                : """
                        <div style="text-align: center; margin: 16px 0; padding: 12px; background-color: #fef3c7; border: 1px dashed #f59e0b; border-radius: 8px;">
                            <p style="margin: 0; font-size: 13px; color: #92400e;">Please transfer directly using the bank account details below.</p>
                        </div>
                        """;

        return String.format(
                """
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>Server Hosting Payment Reminder</title>
                        </head>
                        <body style="margin: 0; padding: 0; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; background-color: #f3f4f6; color: #1f2937;">
                            <table width="100%%" border="0" cellspacing="0" cellpadding="0" style="background-color: #f3f4f6; padding: 30px 10px;">
                                <tr>
                                    <td align="center">
                                        <table width="100%%" style="max-width: 600px; background-color: #ffffff; border-radius: 16px; overflow: hidden; box-shadow: 0 10px 25px rgba(0,0,0,0.08);">
                                            <!-- Header -->
                                            <tr>
                                                <td style="background: linear-gradient(135deg, #ea580c 0%%, #c2410c 100%%); padding: 32px 24px; text-align: center;">
                                                    <h1 style="margin: 0; color: #ffffff; font-size: 22px; font-weight: 700; letter-spacing: -0.5px;">SERVER HOSTING PAYMENT NOTICE</h1>
                                                    <p style="margin: 8px 0 0 0; color: #ffedd5; font-size: 15px;">Billing Period: %s</p>
                                                </td>
                                            </tr>

                                            <!-- Body Content -->
                                            <tr>
                                                <td style="padding: 32px 28px;">
                                                    <p style="margin: 0 0 16px 0; font-size: 15px; line-height: 1.6;">Dear <strong>Hoi An Cooking Class</strong> Team,</p>

                                                    <p style="margin: 0 0 20px 0; font-size: 15px; line-height: 1.6;">
                                                        This is a scheduled monthly notice on the <strong>%sth of every month</strong> regarding the server hosting and database maintenance fee to keep the website running smoothly and continuously.
                                                    </p>

                                                    <!-- Fee Box -->
                                                    <table width="100%%" style="background-color: #fff7ed; border: 1px solid #fed7aa; border-radius: 12px; margin-bottom: 24px; padding: 16px 20px;">
                                                        <tr>
                                                            <td style="font-size: 14px; color: #9a3412; font-weight: 600;">Total Amount Due:</td>
                                                            <td style="text-align: right; font-size: 20px; font-weight: 800; color: #ea580c;">$%s USD <span style="font-size: 16px; font-weight: 600; color: #c2410c;">(~ %s)</span></td>
                                                        </tr>
                                                    </table>

                                                    <!-- Bank Details -->
                                                    <div style="background-color: #f8fafc; border: 1px solid #e2e8f0; border-radius: 12px; padding: 20px; margin-bottom: 24px;">
                                                        <h3 style="margin: 0 0 14px 0; font-size: 15px; color: #0f172a; border-bottom: 1px solid #e2e8f0; padding-bottom: 8px;">Bank Transfer Information</h3>

                                                        <table width="100%%" style="font-size: 14px; line-height: 1.8;">
                                                            <tr>
                                                                <td style="color: #64748b; width: 40%%;">Bank Name:</td>
                                                                <td style="font-weight: 700; color: #0f172a;">%s</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="color: #64748b;">Account Number:</td>
                                                                <td style="font-weight: 800; color: #ea580c; font-size: 16px; letter-spacing: 0.5px;">%s</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="color: #64748b;">Account Holder:</td>
                                                                <td style="font-weight: 700; color: #0f172a; text-transform: uppercase;">%s</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="color: #64748b;">Transfer Note:</td>
                                                                <td style="font-weight: 600; color: #334155; font-style: italic;">Hosting fee %s</td>
                                                            </tr>
                                                        </table>
                                                    </div>

                                                    <!-- QR Code Section -->
                                                    <div style="text-align: center;">
                                                        %s
                                                    </div>

                                                    <p style="margin: 20px 0 0 0; font-size: 14px; color: #6b7280; line-height: 1.6;">
                                                        Upon receiving payment, your server hosting services will continue without interruption. If you have any questions or need assistance, please feel free to reply directly to this email.
                                                    </p>
                                                </td>
                                            </tr>

                                            <!-- Footer -->
                                            <tr>
                                                <td style="background-color: #f9fafb; border-top: 1px solid #f3f4f6; padding: 20px; text-align: center;">
                                                    <p style="margin: 0; font-size: 13px; color: #9ca3af;">
                                                        © %d Hoi An Cooking Class Management. All rights reserved.
                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </body>
                        </html>
                        """,
                monthYear,
                billingProperties.getBillingDay(),
                billingProperties.getAmountUsd(),
                billingProperties.getAmountVnd(),
                billingProperties.getBankName(),
                billingProperties.getBankAccountNumber(),
                billingProperties.getBankAccountOwner(),
                monthYear,
                qrImageSection,
                LocalDate.now().getYear());
    }
}
