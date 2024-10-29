package com.promptoven.exhibitionservice.common.domain;

import com.promptoven.exhibitionservice.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Exhibition extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibition_id")
    private Long id;

    @Comment("기획전 명")
    @Column(nullable = false, length = 50)
    private String name;

    @Comment("기획전 설명")
    @Column(nullable = false, length = 500)
    private String description;

    @Comment("보상 타입")
    @Column(nullable = false, length = 50)
    private String rewardType;

    @Comment("배너 시작일")
    @Column(nullable = false)
    private LocalDateTime bannerStartDate;

    @Comment("배너 종료일")
    @Column(nullable = false)
    private LocalDateTime bannerEndDate;

    @Comment("배너 표시 여부")
    @Column(nullable = false)
    private boolean willShow;

    @Builder
    public Exhibition(Long id, String name, String description, String rewardType, LocalDateTime bannerStartDate, LocalDateTime bannerEndDate, boolean willShow) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.bannerStartDate = bannerStartDate;
        this.bannerEndDate = bannerEndDate;
        this.willShow = willShow;
    }
}
