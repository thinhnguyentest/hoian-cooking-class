package com.example.hoian_cooking.modules.content.service.impl;

import com.example.hoian_cooking.common.exception.AppException;
import com.example.hoian_cooking.common.exception.ErrorCode;
import com.example.hoian_cooking.modules.content.dto.response.ImageResponse;
import com.example.hoian_cooking.modules.content.model.Image;
import com.example.hoian_cooking.modules.content.model.Page;
import com.example.hoian_cooking.modules.content.repository.ImageRepository;
import com.example.hoian_cooking.modules.content.repository.PageRepository;
import com.example.hoian_cooking.modules.content.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;
    private final PageRepository pageRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ImageResponse> getByPageId(Long pageId) {
        return repository.findByPageId(pageId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ImageResponse create(Long pageId, String url, String sourceType, String altText) {
        Page page = pageRepository.findById(pageId)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "Page not found"));
        
        Image image = Image.builder()
                .page(page)
                .url(url)
                .sourceType(sourceType)
                .altText(altText)
                .build();
                
        return mapToResponse(repository.save(image));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new AppException(ErrorCode.NOT_FOUND, "Image not found");
        }
        repository.deleteById(id);
    }

    private ImageResponse mapToResponse(Image entity) {
        return ImageResponse.builder()
                .id(entity.getId())
                .pageId(entity.getPage().getId())
                .url(entity.getUrl())
                .sourceType(entity.getSourceType())
                .altText(entity.getAltText())
                .build();
    }
}
