package com.example.hoian_cooking.modules.content.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuRequest {
    @NotNull(message = "Page ID is required")
    Long pageId;

    @NotBlank(message = "Name is required")
    String name;

    String description;

    Integer sortOrder;
}
