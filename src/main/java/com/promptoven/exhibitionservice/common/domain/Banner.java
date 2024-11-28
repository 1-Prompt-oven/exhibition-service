package com.promptoven.exhibitionservice.common.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banner_id")
    private Long id;

    @Comment("배너 이미지 URL")
    @Column(nullable = false, length = 50)
    private String imageUrl;

    @Comment("기획전 ID")
    @Column(nullable = false)
    private Long exhibitionId;

    @Comment("배너 순서")
    @Column(nullable = false)
    private int bannerOrder;

    @Builder
    public Banner(Long id, String imageUrl, Long exhibitionId, int bannerOrder) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.exhibitionId = exhibitionId;
        this.bannerOrder = bannerOrder;
    }
}
