package com.example.hoian_cooking.modules.content.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.common.dto.PagedResponse;
import com.example.hoian_cooking.modules.content.dto.request.PageRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageResponse;
import com.example.hoian_cooking.modules.content.service.PageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pages")
@RequiredArgsConstructor
public class PageController {

    private final PageService service;

    @GetMapping
    public PagedResponse<PageResponse> getAll(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String slug,
            @RequestParam(required = false) Long pageTypeId,
            Pageable pageable) {
        return PagedResponse.fromPage(service.getAll(title, slug, pageTypeId, pageable));
    }

    @GetMapping("/{id}")
    public ApiResponse<PageResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @PostMapping
    public ApiResponse<PageResponse> create(@Valid @RequestBody PageRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<PageResponse> update(@PathVariable Long id, @Valid @RequestBody PageRequest request) {
        return ApiResponse.success(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success(null);
    }
}
