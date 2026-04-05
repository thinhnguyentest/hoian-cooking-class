package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByPageIdOrderBySortOrder(Long pageId);
    
    @Modifying
    @Transactional
    void deleteByPageId(Long pageId);
}
