package com.example.hoian_cooking.modules.content.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.modules.content.dto.request.PageTypeRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageTypeResponse;
import com.example.hoian_cooking.modules.content.service.PageTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/page-types")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PageTypeController {

    private final PageTypeService service;

    @GetMapping
    public ApiResponse<Page<PageTypeResponse>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            Pageable pageable) {
        return ApiResponse.success(service.getAll(name, code, pageable));
    }

    @GetMapping("/{id}")
    public ApiResponse<PageTypeResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @PostMapping
    public ApiResponse<PageTypeResponse> create(@Valid @RequestBody PageTypeRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<PageTypeResponse> update(@PathVariable Long id, @Valid @RequestBody PageTypeRequest request) {
        return ApiResponse.success(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success(null);
    }
}
