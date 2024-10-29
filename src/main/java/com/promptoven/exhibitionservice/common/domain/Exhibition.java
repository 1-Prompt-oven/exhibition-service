package com.promptoven.exhibitionservice.common.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibition_id")
    private Long exhibitionId;

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

    @Comment("기획전 시작일")
    @Column(nullable = false)
    private LocalDateTime startDate;

    @Comment("기획전 종료일")
    @Column(nullable = false)
    private LocalDateTime endDate;

    @Comment("삭제 여부")
    @Column(nullable = false)
    private boolean deleted;

    @Builder
    public Exhibition(Long exhibitionId,
                      String name,
                      String description,
                      String rewardType,
                      LocalDateTime bannerStartDate,
                      LocalDateTime bannerEndDate,
                      boolean willShow,
                      LocalDateTime startDate,
                      LocalDateTime endDate,
                      boolean deleted) {
        this.exhibitionId = exhibitionId;
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.bannerStartDate = bannerStartDate;
        this.bannerEndDate = bannerEndDate;
        this.willShow = willShow;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deleted = deleted;
    }
}
