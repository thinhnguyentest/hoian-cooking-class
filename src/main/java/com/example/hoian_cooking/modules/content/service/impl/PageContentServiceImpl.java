package com.example.hoian_cooking.modules.content.service.impl;

import com.example.hoian_cooking.modules.content.dto.request.PageContentRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageContentResponse;
import com.example.hoian_cooking.modules.content.model.Page;
import com.example.hoian_cooking.modules.content.model.PageContent;
import com.example.hoian_cooking.modules.content.repository.PageContentRepository;
import com.example.hoian_cooking.modules.content.repository.PageRepository;
import com.example.hoian_cooking.modules.content.service.PageContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PageContentServiceImpl implements PageContentService {

    private final PageContentRepository repository;
    private final PageRepository pageRepository;

    @Override
    public List<PageContentResponse> getByPageId(Long pageId) {
        return repository.findByPageIdOrderBySortOrder(pageId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PageContentResponse> getByPageIdAndSection(Long pageId, String sectionType) {
        return repository.findByPageIdAndSectionTypeOrderBySortOrder(pageId, sectionType)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PageContentResponse getById(Long id) {
        PageContent content = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page content not found with id: " + id));
        return mapToResponse(content);
    }

    @Override
    @Transactional
    public PageContentResponse create(PageContentRequest request) {
        Page page = pageRepository.findById(request.getPageId())
                .orElseThrow(() -> new RuntimeException("Page not found with id: " + request.getPageId()));

        PageContent content = PageContent.builder()
                .page(page)
                .sectionType(request.getSectionType())
                .title(request.getTitle())
                .content(request.getContent())
                .sortOrder(request.getSortOrder() != null ? request.getSortOrder() : 0)
                .build();

        return mapToResponse(repository.save(content));
    }

    @Override
    @Transactional
    public PageContentResponse update(Long id, PageContentRequest request) {
        PageContent content = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page content not found with id: " + id));

        Page page = pageRepository.findById(request.getPageId())
                .orElseThrow(() -> new RuntimeException("Page not found with id: " + request.getPageId()));

        content.setPage(page);
        content.setSectionType(request.getSectionType());
        content.setTitle(request.getTitle());
        content.setContent(request.getContent());
        content.setSortOrder(request.getSortOrder() != null ? request.getSortOrder() : content.getSortOrder());

        return mapToResponse(repository.save(content));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Page content not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private PageContentResponse mapToResponse(PageContent content) {
        return PageContentResponse.builder()
                .id(content.getId())
                .pageId(content.getPage().getId())
                .sectionType(content.getSectionType())
                .title(content.getTitle())
                .content(content.getContent())
                .sortOrder(content.getSortOrder())
                .build();
    }
}
