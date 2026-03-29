package com.example.hoian_cooking.modules.content.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageResponse {
    Long id;
    Long pageId;
    String url;
    String sourceType;
    String altText;
}
