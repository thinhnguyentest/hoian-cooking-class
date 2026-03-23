package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.PageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PageTypeRepository extends JpaRepository<PageType, Long>, JpaSpecificationExecutor<PageType> {
}
