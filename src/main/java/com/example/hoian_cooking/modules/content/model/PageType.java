package com.example.hoian_cooking.modules.content.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "page_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    @OneToMany(mappedBy = "pageType", cascade = CascadeType.ALL)
    private List<Page> pages;
}
