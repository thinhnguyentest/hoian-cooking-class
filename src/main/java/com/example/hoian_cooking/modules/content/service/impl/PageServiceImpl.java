package com.example.hoian_cooking.modules.content.service.impl;

import com.example.hoian_cooking.common.exception.AppException;
import com.example.hoian_cooking.common.exception.ErrorCode;
import com.example.hoian_cooking.modules.content.dto.request.PageRequest;
import com.example.hoian_cooking.modules.content.dto.response.ImageResponse;
import com.example.hoian_cooking.modules.content.dto.response.MenuResponse;
import com.example.hoian_cooking.modules.content.dto.response.PageContentResponse;
import com.example.hoian_cooking.modules.content.dto.response.PageResponse;
import com.example.hoian_cooking.modules.content.model.Page;
import com.example.hoian_cooking.modules.content.model.PageType;
import com.example.hoian_cooking.modules.content.repository.*;
import com.example.hoian_cooking.modules.content.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository repository;
    private final PageTypeRepository pageTypeRepository;
    private final PageContentRepository pageContentRepository;
    private final MenuRepository menuRepository;
    private final ImageRepository imageRepository;

    @Override
    @Transactional(readOnly = true)
    public org.springframework.data.domain.Page<PageResponse> getAll(String title, String slug, Long pageTypeId, Pageable pageable) {
        Specification<Page> spec = PageSpecification.filter(title, slug, pageTypeId);
        return repository.findAll(spec, pageable).map(this::mapToResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse getById(Long id) {
        return repository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "Page not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse getBySlug(String slug) {
        return repository.findBySlug(slug)
                .map(this::mapToResponse)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "Page not found with slug: " + slug));
    }

    @Override
    @Transactional
    public PageResponse create(PageRequest request) {
        PageType pageType = pageTypeRepository.findById(request.getPageTypeId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "Page type not found with id: " + request.getPageTypeId()));
        
        Page page = mapToEntity(request, pageType);
        return mapToResponse(repository.save(page));
    }

    @Override
    @Transactional
    public PageResponse update(Long id, PageRequest request) {
        Page page = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "Page not found with id: " + id));
        
        PageType pageType = pageTypeRepository.findById(request.getPageTypeId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "Page type not found with id: " + request.getPageTypeId()));

        page.setPageType(pageType);
        page.setTitle(request.getTitle());
        page.setDescription(request.getDescription());
        page.setSlug(request.getSlug());

        return mapToResponse(repository.save(page));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new AppException(ErrorCode.NOT_FOUND, "Page not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private PageResponse mapToResponse(Page entity) {
        PageResponse response = PageResponse.builder()
                .id(entity.getId())
                .pageTypeId(entity.getPageType().getId())
                .pageTypeName(entity.getPageType().getName())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .slug(entity.getSlug())
                .build();

        // Aggregate contents
        response.setContents(pageContentRepository.findByPageIdOrderBySortOrder(entity.getId())
                .stream()
                .map(content -> PageContentResponse.builder()
                        .id(content.getId())
                        .pageId(entity.getId())
                        .sectionType(content.getSectionType())
                        .title(content.getTitle())
                        .content(content.getContent())
                        .sortOrder(content.getSortOrder())
                        .build())
                .collect(Collectors.toList()));

        // Aggregate menus
        response.setMenus(menuRepository.findByPageIdOrderBySortOrder(entity.getId())
                .stream()
                .map(menu -> MenuResponse.builder()
                        .id(menu.getId())
                        .pageId(entity.getId())
                        .name(menu.getName())
                        .description(menu.getDescription())
                        .sortOrder(menu.getSortOrder())
                        .build())
                .collect(Collectors.toList()));

        // Aggregate images
        response.setImages(imageRepository.findByPageId(entity.getId())
                .stream()
                .map(image -> ImageResponse.builder()
                        .id(image.getId())
                        .pageId(entity.getId())
                        .url(image.getUrl())
                        .sourceType(image.getSourceType())
                        .build())
                .collect(Collectors.toList()));

        return response;
    }

    private Page mapToEntity(PageRequest request, PageType pageType) {
        return Page.builder()
                .pageType(pageType)
                .title(request.getTitle())
                .description(request.getDescription())
                .slug(request.getSlug())
                .build();
    }
}
