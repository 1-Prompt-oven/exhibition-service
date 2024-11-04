package com.promptoven.exhibitionservice.member.exhibition.vo.out;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class GetExhibitionDetailResponseVo {
    private Long id;
    private String name;
    private String description;
    private String rewardType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Long> exhibitionProductIds;
}
