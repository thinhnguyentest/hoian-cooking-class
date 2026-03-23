package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class PageSpecification {

    public static Specification<Page> filter(String title, String slug, Long pageTypeId) {
        return (root, query, cb) -> {
            Specification<Page> spec = Specification.where((Specification<Page>) null);

            if (StringUtils.hasText(title)) {
                spec = spec.and((r, q, c) -> c.like(c.lower(r.get("title")), "%" + title.toLowerCase() + "%"));
            }

            if (StringUtils.hasText(slug)) {
                spec = spec.and((r, q, c) -> c.equal(r.get("slug"), slug));
            }

            if (pageTypeId != null) {
                spec = spec.and((r, q, c) -> c.equal(r.get("pageType").get("id"), pageTypeId));
            }

            return spec.toPredicate(root, query, cb);
        };
    }
}
