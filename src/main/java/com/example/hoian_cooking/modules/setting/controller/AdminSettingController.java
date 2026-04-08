package com.example.hoian_cooking.modules.setting.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.modules.setting.dto.SettingUpdateRequest;
import com.example.hoian_cooking.modules.setting.model.SystemSetting;
import com.example.hoian_cooking.modules.setting.service.SystemSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/settings")
@RequiredArgsConstructor
public class AdminSettingController {
    private final SystemSettingService systemSettingService;

    @GetMapping("/{key}")
    public ApiResponse<SystemSetting> getSetting(@PathVariable String key) {
        return ApiResponse.success(systemSettingService.getSetting(key).orElse(null));
    }

    @PutMapping("/{key}")
    public ApiResponse<SystemSetting> updateSetting(
            @PathVariable String key,
            @RequestBody SettingUpdateRequest request) {
        return ApiResponse.success(systemSettingService.updateSetting(key, request.getValue(), request.getDescription()));
    }
}
