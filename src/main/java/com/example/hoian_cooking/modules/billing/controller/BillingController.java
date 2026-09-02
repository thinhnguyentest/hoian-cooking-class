package com.example.hoian_cooking.modules.billing.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.modules.billing.config.BillingProperties;
import com.example.hoian_cooking.modules.billing.service.BillingEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/billing")
@RequiredArgsConstructor
public class BillingController {

    private final BillingEmailService billingEmailService;
    private final BillingProperties billingProperties;

    /**
     * Endpoint to trigger hosting payment reminder email manually for testing
     *
     * @param email Optional target email (falls back to configured client email if not provided)
     */
    @PostMapping("/send-reminder")
    public ResponseEntity<ApiResponse<Map<String, Object>>> sendReminderManually(
            @RequestParam(required = false) String email) {
        
        String targetEmail = (email != null && !email.trim().isEmpty()) 
                ? email.trim() 
                : billingProperties.getClientEmail();

        boolean sent = billingEmailService.sendHostingFeeReminder(targetEmail);

        Map<String, Object> result = new HashMap<>();
        result.put("recipient", targetEmail);
        result.put("sent", sent);
        result.put("billingProperties", Map.of(
                "cron", billingProperties.getCron(),
                "billingDay", billingProperties.getBillingDay(),
                "amountUsd", billingProperties.getAmountUsd(),
                "amountVnd", billingProperties.getAmountVnd(),
                "bankName", billingProperties.getBankName(),
                "bankAccountNumber", billingProperties.getBankAccountNumber(),
                "bankAccountOwner", billingProperties.getBankAccountOwner()
        ));

        if (sent) {
            return ResponseEntity.ok(ApiResponse.success(result));
        } else {
            return ResponseEntity.badRequest().body(
                    ApiResponse.error("BILLING_SEND_FAILED", "Failed to send email. Please verify SMTP settings (MAIL_USERNAME/MAIL_PASSWORD) and CLIENT_EMAIL.")
            );
        }
    }
}
