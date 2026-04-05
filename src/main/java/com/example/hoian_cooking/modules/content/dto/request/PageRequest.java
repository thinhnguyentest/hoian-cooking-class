package com.example.hoian_cooking.modules.content.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageRequest {

    @NotNull(message = "Page type ID is required")
    Long pageTypeId;

    @NotBlank(message = "Title is required")
    @Size(max = 255)
    String title;

    String description;

    @NotBlank(message = "Slug is required")
    @Size(max = 255)
    String slug;

    List<PageContentRequest> contents;
    List<MenuRequest> menus;
    List<ImageRequest> images;
}
