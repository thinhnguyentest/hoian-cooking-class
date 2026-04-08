package com.example.hoian_cooking.modules.setting.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "system_settings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SystemSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "setting_key", unique = true, nullable = false)
    String settingKey;

    @Column(name = "setting_value", columnDefinition = "TEXT")
    String settingValue;

    String description;
}
