package com.example.hoian_cooking.modules.content.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "page_contents")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id")
    Page page;

    @Column(name = "section_type")
    String sectionType; // EXPERIENCE, HIGHLIGHTS

    String title;

    @Column(columnDefinition = "TEXT")
    String content;

    @Column(name = "sort_order")
    Integer sortOrder;
}
