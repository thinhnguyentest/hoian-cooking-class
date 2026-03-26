package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class PageSpecification {

    public static Specification<Page> filter(String title, String slug, Long pageTypeId) {
        return (root, query, cb) -> {
            Specification<Page> spec = null;

            if (StringUtils.hasText(title)) {
                spec = Specification.where((r, q, c) -> c.like(c.lower(r.get("title")), "%" + title.toLowerCase() + "%"));
            }

            if (StringUtils.hasText(slug)) {
                Specification<Page> slugSpec = (r, q, c) -> c.equal(r.get("slug"), slug);
                spec = spec == null ? Specification.where(slugSpec) : spec.and(slugSpec);
            }

            if (pageTypeId != null) {
                Specification<Page> typeSpec = (r, q, c) -> c.equal(r.get("pageType").get("id"), pageTypeId);
                spec = spec == null ? Specification.where(typeSpec) : spec.and(typeSpec);
            }

            return spec != null ? spec.toPredicate(root, query, cb) : cb.conjunction();
        };
    }
}
