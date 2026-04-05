package com.example.hoian_cooking.modules.content.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id")
    private Page page;

    @Column(nullable = false)
    private String url;

    @Column(name = "source_type", nullable = false)
    private String sourceType;

    @Column(name = "alt_text")
    private String altText;

    @Column(name = "public_id")
    private String publicId;
}
