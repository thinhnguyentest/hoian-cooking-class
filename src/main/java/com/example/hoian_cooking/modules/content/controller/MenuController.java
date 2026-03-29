package com.example.hoian_cooking.modules.content.controller;

import com.example.hoian_cooking.common.dto.ApiResponse;
import com.example.hoian_cooking.modules.content.dto.request.MenuRequest;
import com.example.hoian_cooking.modules.content.dto.response.MenuResponse;
import com.example.hoian_cooking.modules.content.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService service;

    @GetMapping("/page/{pageId}")
    public ApiResponse<List<MenuResponse>> getByPageId(@PathVariable Long pageId) {
        return ApiResponse.success(service.getByPageId(pageId));
    }

    @GetMapping("/{id}")
    public ApiResponse<MenuResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @PostMapping
    public ApiResponse<MenuResponse> create(@Valid @RequestBody MenuRequest request) {
        return ApiResponse.success(service.create(request));
    }

    @PutMapping("/{id}")
    public ApiResponse<MenuResponse> update(@PathVariable Long id, @Valid @RequestBody MenuRequest request) {
        return ApiResponse.success(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success(null);
    }
}
