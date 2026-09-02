package com.example.hoian_cooking.modules.billing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.billing")
public class BillingProperties {

    /**
     * Enable or disable automated hosting fee reminder email job
     */
    private boolean enabled = true;

    /**
     * Cron expression for scheduled job (Default: 8:00 PM on the 19th of every month)
     */
    private String cron = "0 0 20 19 * *";

    /**
     * Client email address to receive payment reminder
     */
    private String clientEmail;

    /**
     * Sender email address (defaults to spring.mail.username if empty)
     */
    private String fromEmail;

    /**
     * Display name for sender
     */
    private String senderName = "Hoi An Cooking - Hosting Management";

    /**
     * Payment amount in USD
     */
    private String amountUsd = "15";

    /**
     * Payment amount converted to VND
     */
    private String amountVnd = "393,000 VND";

    /**
     * Beneficiary bank name
     */
    private String bankName = "MBBank";

    /**
     * Beneficiary bank account number
     */
    private String bankAccountNumber = "0703224025";

    /**
     * Beneficiary account holder name
     */
    private String bankAccountOwner = "NGUYEN DUC THINH";

    /**
     * Due billing day of the month
     */
    private String billingDay = "19";

    /**
     * Path to QR code payment image (in classpath resources or file system)
     */
    private String qrImagePath = "images/QR.jpg";
}
