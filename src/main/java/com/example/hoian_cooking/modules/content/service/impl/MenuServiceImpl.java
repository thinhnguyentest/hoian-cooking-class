package com.example.hoian_cooking.modules.content.service.impl;

import com.example.hoian_cooking.modules.content.dto.request.MenuRequest;
import com.example.hoian_cooking.modules.content.dto.response.MenuResponse;
import com.example.hoian_cooking.modules.content.model.Menu;
import com.example.hoian_cooking.modules.content.model.Page;
import com.example.hoian_cooking.modules.content.repository.MenuRepository;
import com.example.hoian_cooking.modules.content.repository.PageRepository;
import com.example.hoian_cooking.modules.content.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository repository;
    private final PageRepository pageRepository;

    @Override
    public List<MenuResponse> getByPageId(Long pageId) {
        return repository.findByPageIdOrderBySortOrder(pageId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MenuResponse getById(Long id) {
        Menu menu = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));
        return mapToResponse(menu);
    }

    @Override
    @Transactional
    public MenuResponse create(MenuRequest request) {
        Page page = pageRepository.findById(request.getPageId())
                .orElseThrow(() -> new RuntimeException("Page not found with id: " + request.getPageId()));

        Menu menu = Menu.builder()
                .page(page)
                .name(request.getName())
                .description(request.getDescription())
                .sortOrder(request.getSortOrder() != null ? request.getSortOrder() : 0)
                .build();

        return mapToResponse(repository.save(menu));
    }

    @Override
    @Transactional
    public MenuResponse update(Long id, MenuRequest request) {
        Menu menu = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));

        Page page = pageRepository.findById(request.getPageId())
                .orElseThrow(() -> new RuntimeException("Page not found with id: " + request.getPageId()));

        menu.setPage(page);
        menu.setName(request.getName());
        menu.setDescription(request.getDescription());
        menu.setSortOrder(request.getSortOrder() != null ? request.getSortOrder() : menu.getSortOrder());

        return mapToResponse(repository.save(menu));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Menu not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private MenuResponse mapToResponse(Menu menu) {
        return MenuResponse.builder()
                .id(menu.getId())
                .pageId(menu.getPage().getId())
                .name(menu.getName())
                .description(menu.getDescription())
                .sortOrder(menu.getSortOrder())
                .build();
    }
}
