package com.example.hoian_cooking.modules.content.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuResponse {
    Long id;
    Long pageId;
    String name;
    String description;
    Integer sortOrder;
}
