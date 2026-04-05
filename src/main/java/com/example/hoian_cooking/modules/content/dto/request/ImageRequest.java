package com.example.hoian_cooking.modules.content.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageRequest {
    Long id;
    String url;
    String sourceType;
    String altText;
    String publicId;
}
