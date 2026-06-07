package com.example.hoian_cooking.modules.content.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageResponse {
    Long id;
    Long pageTypeId;
    String pageTypeName;
    String title;
    String description;
    String slug;
    String duration;
    String groupSize;
    String cancellation;
    BigDecimal price;

    // Aggregated content
    List<PageContentResponse> contents;
    List<MenuResponse> menus;
    List<ImageResponse> images;
}
