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
public class PageContentRequest {
    @NotNull(message = "Page ID is required")
    Long pageId;

    @NotBlank(message = "Section type is required")
    String sectionType;

    String title;

    @NotBlank(message = "Content is required")
    String content;

    Integer sortOrder;
}
