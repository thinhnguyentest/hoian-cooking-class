package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByPageIdOrderBySortOrder(Long pageId);
}
