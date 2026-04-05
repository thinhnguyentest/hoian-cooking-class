package com.example.hoian_cooking.modules.content.service.impl;

import com.example.hoian_cooking.common.exception.AppException;
import com.example.hoian_cooking.common.exception.ErrorCode;
import com.example.hoian_cooking.modules.content.dto.request.ImageRequest;
import com.example.hoian_cooking.modules.content.dto.request.MenuRequest;
import com.example.hoian_cooking.modules.content.dto.request.PageContentRequest;
import com.example.hoian_cooking.modules.content.dto.request.PageRequest;
import com.example.hoian_cooking.modules.content.dto.response.ImageResponse;
import com.example.hoian_cooking.modules.content.dto.response.MenuResponse;
import com.example.hoian_cooking.modules.content.dto.response.PageContentResponse;
import com.example.hoian_cooking.modules.content.dto.response.PageResponse;
import com.example.hoian_cooking.modules.content.model.ImageAsset;
import com.example.hoian_cooking.modules.content.model.Menu;
import com.example.hoian_cooking.modules.content.model.Page;
import com.example.hoian_cooking.modules.content.model.PageContent;
import com.example.hoian_cooking.modules.content.model.PageType;
import com.example.hoian_cooking.modules.content.repository.*;
import com.example.hoian_cooking.modules.content.service.CloudinaryService;
import com.example.hoian_cooking.modules.content.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository repository;
    private final PageTypeRepository pageTypeRepository;
    private final PageContentRepository pageContentRepository;
    private final MenuRepository menuRepository;
    private final ImageRepository imageRepository;
    private final CloudinaryService cloudinaryService;

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
        Page savedPage = repository.save(page);
        
        syncContents(savedPage, request.getContents());
        syncMenus(savedPage, request.getMenus());
        syncImages(savedPage, request.getImages());
        
        return mapToResponse(savedPage);
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

        Page savedPage = repository.save(page);
        
        syncContents(savedPage, request.getContents());
        syncMenus(savedPage, request.getMenus());
        syncImages(savedPage, request.getImages());

        return mapToResponse(savedPage);
    }

    private void syncContents(Page page, List<PageContentRequest> contentRequests) {
        if (contentRequests == null) return;

        // Get existing contents
        List<PageContent> existingContents = pageContentRepository.findByPageIdOrderBySortOrder(page.getId());
        Set<Long> incomingIds = contentRequests.stream()
                .filter(c -> c.getId() != null)
                .map(PageContentRequest::getId)
                .collect(Collectors.toSet());

        // Delete items not in incoming request
        existingContents.stream()
                .filter(c -> !incomingIds.contains(c.getId()))
                .forEach(pageContentRepository::delete);

        // Update or Insert
        for (PageContentRequest req : contentRequests) {
            PageContent content;
            if (req.getId() != null) {
                content = pageContentRepository.findById(req.getId())
                        .orElse(new PageContent());
            } else {
                content = new PageContent();
            }
            content.setPage(page);
            content.setSectionType(req.getSectionType());
            content.setTitle(req.getTitle());
            content.setContent(req.getContent());
            content.setSortOrder(req.getSortOrder());
            pageContentRepository.save(content);
        }
    }

    private void syncMenus(Page page, List<MenuRequest> menuRequests) {
        if (menuRequests == null) return;

        // Get existing menus
        List<Menu> existingMenus = menuRepository.findByPageIdOrderBySortOrder(page.getId());
        Set<Long> incomingIds = menuRequests.stream()
                .filter(m -> m.getId() != null)
                .map(MenuRequest::getId)
                .collect(Collectors.toSet());

        // Delete items not in incoming request
        existingMenus.stream()
                .filter(m -> !incomingIds.contains(m.getId()))
                .forEach(menuRepository::delete);

        // Update or Insert
        for (MenuRequest req : menuRequests) {
            Menu menu;
            if (req.getId() != null) {
                menu = menuRepository.findById(req.getId())
                        .orElse(new Menu());
            } else {
                menu = new Menu();
            }
            menu.setPage(page); // Use setPage(page) instead of setPageId
            menu.setName(req.getName());
            menu.setDescription(req.getDescription());
            menu.setSortOrder(req.getSortOrder());
            menuRepository.save(menu);
        }
    }

    private void syncImages(Page page, List<ImageRequest> imageRequests) {
        if (imageRequests == null) return;

        // Get existing images
        List<ImageAsset> existingImages = imageRepository.findByPageId(page.getId());
        Set<Long> incomingIds = imageRequests.stream()
                .filter(i -> i.getId() != null)
                .map(ImageRequest::getId)
                .collect(Collectors.toSet());

        // Delete items not in incoming request
        existingImages.stream()
                .filter(i -> !incomingIds.contains(i.getId()))
                .forEach(image -> {
                    // Delete from Cloudinary if publicId exists
                    if (image.getPublicId() != null) {
                        try {
                            cloudinaryService.delete(image.getPublicId());
                        } catch (Exception e) {
                            // Log error but continue
                            System.err.println("Failed to delete image from Cloudinary: " + image.getPublicId());
                        }
                    }
                    imageRepository.delete(image);
                });

        // Update or Insert
        for (ImageRequest req : imageRequests) {
            ImageAsset image;
            if (req.getId() != null) {
                image = imageRepository.findById(req.getId())
                        .orElse(new ImageAsset());
            } else {
                image = new ImageAsset();
            }
            image.setPage(page);
            image.setUrl(req.getUrl());
            image.setSourceType(req.getSourceType());
            image.setAltText(req.getAltText());
            image.setPublicId(req.getPublicId());
            imageRepository.save(image);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new AppException(ErrorCode.NOT_FOUND, "Page not found with id: " + id);
        }
        pageContentRepository.deleteByPageId(id);
        menuRepository.deleteByPageId(id);
        imageRepository.deleteByPageId(id);
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

        response.setImages(imageRepository.findByPageId(entity.getId())
                .stream()
                .map(image -> ImageResponse.builder()
                        .id(image.getId())
                        .pageId(entity.getId())
                        .url(image.getUrl())
                        .sourceType(image.getSourceType())
                        .altText(image.getAltText())
                        .publicId(image.getPublicId())
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
