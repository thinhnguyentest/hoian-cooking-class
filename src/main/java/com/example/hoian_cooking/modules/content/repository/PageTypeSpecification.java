package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.PageType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class PageTypeSpecification {

    public static Specification<PageType> filter(String name, String code) {
        return (root, query, cb) -> {
            Specification<PageType> spec = null;

            if (StringUtils.hasText(name)) {
                spec = Specification.where((r, q, c) -> c.like(c.lower(r.get("name")), "%" + name.toLowerCase() + "%"));
            }

            if (StringUtils.hasText(code)) {
                Specification<PageType> codeSpec = (r, q, c) -> c.equal(r.get("code"), code);
                spec = spec == null ? Specification.where(codeSpec) : spec.and(codeSpec);
            }

            return spec != null ? spec.toPredicate(root, query, cb) : cb.conjunction();
        };
    }
}
