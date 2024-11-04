package com.promptoven.exhibitionservice.member.exhibition.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetExhibitionDetailResponseVo {
    private Long id;
    private String name;
    private String description;
    private String rewardType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Long> exhibitionProductIds;

    @Builder
    public GetExhibitionDetailResponseVo(Long id, String name, String description, String rewardType,
                                         LocalDateTime startDate, LocalDateTime endDate, List<Long> exhibitionProductIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.exhibitionProductIds = exhibitionProductIds;
    }
}
