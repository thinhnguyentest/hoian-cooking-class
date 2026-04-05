package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.ImageAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageAsset, Long> {
    List<ImageAsset> findByPageId(Long pageId);
    
    @Modifying
    @Transactional
    void deleteByPageId(Long pageId);
}
