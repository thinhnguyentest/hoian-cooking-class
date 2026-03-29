package com.example.hoian_cooking.common.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class PagedResponse<T> {
    private List<T> data;
    private Metadata metadata;

    @Data
    @Builder
    public static class Metadata {
        private long totalRecords;
        private int currentPage;
        private int pageSize;
        private int totalPages;
    }

    public static <T> PagedResponse<T> fromPage(org.springframework.data.domain.Page<T> page) {
        return PagedResponse.<T>builder()
                .data(page.getContent())
                .metadata(Metadata.builder()
                        .totalRecords(page.getTotalElements())
                        .currentPage(page.getNumber() + 1)
                        .pageSize(page.getSize())
                        .totalPages(page.getTotalPages())
                        .build())
                .build();
    }
}
