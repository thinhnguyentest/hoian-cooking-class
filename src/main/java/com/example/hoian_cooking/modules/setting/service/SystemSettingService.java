package com.example.hoian_cooking.modules.setting.service;

import com.example.hoian_cooking.modules.setting.model.SystemSetting;
import com.example.hoian_cooking.modules.setting.repository.SystemSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemSettingService {
    private final SystemSettingRepository systemSettingRepository;

    public Optional<SystemSetting> getSetting(String key) {
        return systemSettingRepository.findBySettingKey(key);
    }

    @Transactional
    public SystemSetting updateSetting(String key, String value, String description) {
        SystemSetting setting = systemSettingRepository.findBySettingKey(key)
                .orElse(SystemSetting.builder()
                        .settingKey(key)
                        .build());
        
        setting.setSettingValue(value);
        if (description != null) {
            setting.setDescription(description);
        }
        
        return systemSettingRepository.save(setting);
    }
}
