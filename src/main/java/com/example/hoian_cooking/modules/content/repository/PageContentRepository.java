package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.PageContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PageContentRepository extends JpaRepository<PageContent, Long> {
    List<PageContent> findByPageIdOrderBySortOrder(Long pageId);
    List<PageContent> findByPageIdAndSectionTypeOrderBySortOrder(Long pageId, String sectionType);
    
    @Modifying
    @Transactional
    void deleteByPageId(Long pageId);
}
