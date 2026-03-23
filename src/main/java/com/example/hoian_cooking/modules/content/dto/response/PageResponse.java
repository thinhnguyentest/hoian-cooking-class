package com.example.hoian_cooking.modules.content.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageResponse {
    Long id;
    Long pageTypeId;
    String pageTypeName;
    String title;
    String description;
    String slug;
}
