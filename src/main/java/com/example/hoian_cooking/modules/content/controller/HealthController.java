package com.example.hoian_cooking.modules.content.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@Slf4j
public class HealthController {

    private static final OffsetDateTime START_TIME = OffsetDateTime.now();

    @GetMapping("/")
    public Map<String, String> index() {
        return Map.of(
                "message a", "Hoi An Cooking Class API is running.",
                "status", "ALIVE",
                "health_check", "/api/v1/health");
    }

    @GetMapping("/api/v1/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        log.info("Health check endpoint hit at {}", OffsetDateTime.now());

        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "message", "Hoi An Backend is awake and ready!",
                "timestamp", OffsetDateTime.now().toString(),
                "startTime", START_TIME.toString(),
                "version", "0.0.1-SNAPSHOT"));
    }
}
