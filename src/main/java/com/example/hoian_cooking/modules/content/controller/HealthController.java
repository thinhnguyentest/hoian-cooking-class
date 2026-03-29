package com.example.hoian_cooking.modules.content.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/health")
@Slf4j
public class HealthController {

    private static final OffsetDateTime START_TIME = OffsetDateTime.now();

    @GetMapping
    public ResponseEntity<Map<String, Object>> healthCheck() {
        log.info("Health check endpoint hit at {}", OffsetDateTime.now());
        
        return ResponseEntity.ok(Map.of(
            "status", "UP",
            "message", "Hoi An Backend is awake and ready!",
            "timestamp", OffsetDateTime.now().toString(),
            "startTime", START_TIME.toString(),
            "version", "0.0.1-SNAPSHOT"
        ));
    }
}
