package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByPageId(Long pageId);
}
