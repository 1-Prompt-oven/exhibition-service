package com.promptoven.exhibitionservice.common.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
                      LocalDateTime startDate,
                      LocalDateTime endDate,
                      boolean deleted) {
        this.exhibitionId = exhibitionId;
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deleted = deleted;
    }
}
