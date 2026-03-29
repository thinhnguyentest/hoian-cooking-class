package com.example.hoian_cooking.modules.content.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageContentResponse {
    Long id;
    Long pageId;
    String sectionType;
    String title;
    String content;
    Integer sortOrder;
}
