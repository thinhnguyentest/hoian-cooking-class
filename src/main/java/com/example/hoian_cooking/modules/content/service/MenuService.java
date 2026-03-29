package com.example.hoian_cooking.modules.content.service;

import com.example.hoian_cooking.modules.content.dto.request.MenuRequest;
import com.example.hoian_cooking.modules.content.dto.response.MenuResponse;

import java.util.List;

public interface MenuService {
    List<MenuResponse> getByPageId(Long pageId);
    MenuResponse getById(Long id);
    MenuResponse create(MenuRequest request);
    MenuResponse update(Long id, MenuRequest request);
    void delete(Long id);
}
