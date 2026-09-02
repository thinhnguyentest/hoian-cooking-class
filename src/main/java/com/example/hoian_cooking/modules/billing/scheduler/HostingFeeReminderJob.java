package com.example.hoian_cooking.modules.billing.scheduler;

import com.example.hoian_cooking.modules.billing.config.BillingProperties;
import com.example.hoian_cooking.modules.billing.service.BillingEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HostingFeeReminderJob {

    private final BillingEmailService billingEmailService;
    private final BillingProperties billingProperties;

    // Scheduled job running based on cron expression (Default: 8:00 PM on the 19th of each month)
    @Scheduled(cron = "#{@billingProperties.cron}", zone = "Asia/Ho_Chi_Minh")
    public void executeHostingFeeReminder() {
        if (!billingProperties.isEnabled()) {
            log.info("HostingFeeReminderJob is disabled (app.billing.enabled=false). Skipping execution.");
            return;
        }

        log.info("=== [START] HostingFeeReminderJob: Sending monthly hosting payment reminder email ===");
        boolean success = billingEmailService.sendHostingFeeReminder(null);
        if (success) {
            log.info("=== [SUCCESS] HostingFeeReminderJob completed successfully ===");
        } else {
            log.warn("=== [FAILED] HostingFeeReminderJob failed to send reminder email ===");
        }
    }
}
