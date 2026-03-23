package com.example.hoian_cooking.modules.content.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
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
