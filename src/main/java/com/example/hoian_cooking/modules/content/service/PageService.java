package com.example.hoian_cooking.modules.content.service;

import com.example.hoian_cooking.modules.content.dto.request.PageRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PageService {
    Page<PageResponse> getAll(String title, String slug, Long pageTypeId, Pageable pageable);
    PageResponse getById(Long id);
    PageResponse getBySlug(String slug);
    PageResponse create(PageRequest request);
    PageResponse update(Long id, PageRequest request);
    void delete(Long id);
}
