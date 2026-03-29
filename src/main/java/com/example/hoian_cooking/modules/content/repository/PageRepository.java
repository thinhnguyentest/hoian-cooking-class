package com.example.hoian_cooking.modules.content.repository;

import com.example.hoian_cooking.modules.content.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Page, Long>, JpaSpecificationExecutor<Page> {
    Optional<Page> findBySlug(String slug);
}
