package com.example.hoian_cooking.modules.content.service.impl;

import com.example.hoian_cooking.common.exception.AppException;
import com.example.hoian_cooking.common.exception.ErrorCode;
import com.example.hoian_cooking.modules.content.dto.request.PageTypeRequest;
import com.example.hoian_cooking.modules.content.dto.response.PageTypeResponse;
import com.example.hoian_cooking.modules.content.model.PageType;
import com.example.hoian_cooking.modules.content.repository.PageTypeRepository;
import com.example.hoian_cooking.modules.content.repository.PageTypeSpecification;
import com.example.hoian_cooking.modules.content.service.PageTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PageTypeServiceImpl implements PageTypeService {

    private final PageTypeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<PageTypeResponse> getAll(String name, String code, Pageable pageable) {
        Specification<PageType> spec = PageTypeSpecification.filter(name, code);
        return repository.findAll(spec, pageable).map(this::mapToResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public PageTypeResponse getById(Long id) {
        return repository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "Page type not found with id: " + id));
    }

    @Override
    @Transactional
    public PageTypeResponse create(PageTypeRequest request) {
        PageType pageType = mapToEntity(request);
        return mapToResponse(repository.save(pageType));
    }

    @Override
    @Transactional
    public PageTypeResponse update(Long id, PageTypeRequest request) {
        PageType pageType = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "Page type not found with id: " + id));
        
        pageType.setName(request.getName());
        pageType.setCode(request.getCode());
        pageType.setDescription(request.getDescription());
        
        return mapToResponse(repository.save(pageType));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new AppException(ErrorCode.NOT_FOUND, "Page type not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private PageTypeResponse mapToResponse(PageType entity) {
        return PageTypeResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .description(entity.getDescription())
                .build();
    }

    private PageType mapToEntity(PageTypeRequest request) {
        return PageType.builder()
                .name(request.getName())
                .code(request.getCode())
                .description(request.getDescription())
                .build();
    }
}
