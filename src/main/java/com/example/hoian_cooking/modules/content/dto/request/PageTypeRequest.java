package com.example.hoian_cooking.modules.content.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageTypeRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 255)
    String name;

    @NotBlank(message = "Code is required")
    @Size(max = 50)
    String code;

    String description;
}
