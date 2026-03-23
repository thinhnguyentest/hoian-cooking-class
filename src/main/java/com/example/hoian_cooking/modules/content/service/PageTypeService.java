package com.example.hoian_cooking.modules.content.service;

import com.example.hoian_cooking.modules.content.dto.request.PageTypeRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageTypeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PageTypeService {
    Page<PageTypeResponse> getAll(String name, String code, Pageable pageable);
    PageTypeResponse getById(Long id);
    PageTypeResponse create(PageTypeRequest request);
    PageTypeResponse update(Long id, PageTypeRequest request);
    void delete(Long id);
}
