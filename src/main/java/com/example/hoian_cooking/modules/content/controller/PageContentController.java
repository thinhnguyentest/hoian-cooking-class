package com.example.hoian_cooking.modules.content.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.modules.content.dto.request.PageContentRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageContentResponse;
import com.example.hoian_cooking.modules.content.service.PageContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/page-contents")
@RequiredArgsConstructor
public class PageContentController {

    private final PageContentService service;

    @GetMapping("/page/{pageId}")
    public ApiResponse<List<PageContentResponse>> getByPageId(
            @PathVariable Long pageId,
            @RequestParam(required = false) String sectionType) {
        if (sectionType != null) {
            return ApiResponse.success(service.getByPageIdAndSection(pageId, sectionType));
        }
        return ApiResponse.success(service.getByPageId(pageId));
    }

    @GetMapping("/{id}")
    public ApiResponse<PageContentResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @PostMapping
    public ApiResponse<PageContentResponse> create(@Valid @RequestBody PageContentRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<PageContentResponse> update(@PathVariable Long id, @Valid @RequestBody PageContentRequest request) {
        return ApiResponse.success(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success(null);
    }
}
