package com.example.hoian_cooking.modules.content.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.modules.content.dto.response.ImageResponse;
import com.example.hoian_cooking.modules.content.service.CloudinaryService;
import com.example.hoian_cooking.modules.content.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService service;
    private final CloudinaryService cloudinaryService;
    @GetMapping
    public ApiResponse<List<ImageResponse>> getAll() {
        return ApiResponse.success(service.getAll());
    }

    @GetMapping("/page/{pageId}")
    public ApiResponse<List<ImageResponse>> getByPageId(@PathVariable Long pageId) {
        return ApiResponse.success(service.getByPageId(pageId));
    }

    @PostMapping("/page/{pageId}")
    public ApiResponse<ImageResponse> create(
            @PathVariable Long pageId,
            @RequestParam String url,
            @RequestParam String sourceType,
            @RequestParam(required = false) String altText,
            @RequestParam(required = false) String publicId) {
        return ApiResponse.success(service.create(pageId, url, sourceType, altText, publicId));
    }

    @PostMapping("/upload")
    public ApiResponse<Map<String, Object>> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(defaultValue = "hoian_cooking") String folder) throws IOException {
        return ApiResponse.success(cloudinaryService.upload(file, folder));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success(null);
    }
}
