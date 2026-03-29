package com.example.hoian_cooking.modules.content.service;

import com.example.hoian_cooking.modules.content.dto.response.ImageResponse;

import java.util.List;

public interface ImageService {
    List<ImageResponse> getByPageId(Long pageId);
    ImageResponse create(Long pageId, String url, String sourceType, String altText);
    void delete(Long id);
}
