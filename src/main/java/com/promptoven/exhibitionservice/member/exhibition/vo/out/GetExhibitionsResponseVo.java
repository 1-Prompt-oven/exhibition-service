package com.promptoven.exhibitionservice.member.exhibition.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetExhibitionsResponseVo {

    private Long exhibitionId;
    private String name;
    private String description;
    private String rewardType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String imageUrl;

    @Builder
    public GetExhibitionsResponseVo(Long exhibitionId, String name, String description, String rewardType,
                                    LocalDateTime startDate, LocalDateTime endDate, String imageUrl) {
        this.exhibitionId = exhibitionId;
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imageUrl = imageUrl;
    }
}
