package com.example.hoian_cooking.modules.setting.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.modules.setting.service.SystemSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public/settings")
@RequiredArgsConstructor
public class PublicSettingController {
    private final SystemSettingService systemSettingService;

    @GetMapping("/{key}")
    public ApiResponse<String> getSetting(@PathVariable String key) {
        return ApiResponse.success(systemSettingService.getSetting(key)
                .map(setting -> setting.getSettingValue())
                .orElse(null));
    }
}
