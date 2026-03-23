package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.PageType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class PageTypeSpecification {

    public static Specification<PageType> filter(String name, String code) {
        return (root, query, cb) -> {
            Specification<PageType> spec = Specification.where((Specification<PageType>) null);

            if (StringUtils.hasText(name)) {
                spec = spec.and((r, q, c) -> c.like(c.lower(r.get("name")), "%" + name.toLowerCase() + "%"));
            }

            if (StringUtils.hasText(code)) {
                spec = spec.and((r, q, c) -> c.equal(r.get("code"), code));
            }

            return spec.toPredicate(root, query, cb);
        };
    }
}
