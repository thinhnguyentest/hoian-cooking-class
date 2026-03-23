package com.example.hoian_cooking.modules.content.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_type_id")
    private PageType pageType;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false, unique = true)
    private String slug;
}
