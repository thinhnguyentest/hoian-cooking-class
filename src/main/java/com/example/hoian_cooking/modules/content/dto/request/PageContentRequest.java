package com.example.hoian_cooking.modules.content.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class PageContentRequest {
    Long id;

    Long pageId;

    @NotBlank(message = "Section type is required")
    String sectionType;

    String title;

    @NotBlank(message = "Content is required")
    String content;

    Integer sortOrder;
}
