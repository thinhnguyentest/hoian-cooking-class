package com.example.hoian_cooking.modules.content.service;

import com.example.hoian_cooking.modules.content.dto.request.PageContentRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageContentResponse;

import java.util.List;

public interface PageContentService {
    List<PageContentResponse> getByPageId(Long pageId);
    List<PageContentResponse> getByPageIdAndSection(Long pageId, String sectionType);
    PageContentResponse getById(Long id);
    PageContentResponse create(PageContentRequest request);
    PageContentResponse update(Long id, PageContentRequest request);
    void delete(Long id);
}
