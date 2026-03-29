package com.example.hoian_cooking.modules.content.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.modules.content.dto.response.ImageResponse;
import com.example.hoian_cooking.modules.content.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService service;

    @GetMapping("/page/{pageId}")
    public ApiResponse<List<ImageResponse>> getByPageId(@PathVariable Long pageId) {
        return ApiResponse.success(service.getByPageId(pageId));
    }

    @PostMapping("/page/{pageId}")
    public ApiResponse<ImageResponse> create(
            @PathVariable Long pageId,
            @RequestParam String url,
            @RequestParam String sourceType,
            @RequestParam(required = false) String altText) {
        return ApiResponse.success(service.create(pageId, url, sourceType, altText));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success(null);
    }
}
