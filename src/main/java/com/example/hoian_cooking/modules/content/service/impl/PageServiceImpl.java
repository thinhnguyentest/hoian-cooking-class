package com.example.hoian_cooking.modules.content.service.impl;

import com.example.hoian_cooking.common.exception.AppException;
import com.example.hoian_cooking.common.exception.ErrorCode;
import com.example.hoian_cooking.modules.content.dto.request.PageRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageResponse;
import com.example.hoian_cooking.modules.content.model.Page;
import com.example.hoian_cooking.modules.content.model.PageType;
import com.example.hoian_cooking.modules.content.repository.PageRepository;
import com.example.hoian_cooking.modules.content.repository.PageSpecification;
import com.example.hoian_cooking.modules.content.repository.PageTypeRepository;
import com.example.hoian_cooking.modules.content.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository repository;
    private final PageTypeRepository pageTypeRepository;

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
        return PageResponse.builder()
                .id(entity.getId())
                .pageTypeId(entity.getPageType().getId())
                .pageTypeName(entity.getPageType().getName())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .slug(entity.getSlug())
                .build();
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
