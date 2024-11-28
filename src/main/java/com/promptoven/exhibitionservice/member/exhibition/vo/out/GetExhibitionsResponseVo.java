package com.promptoven.exhibitionservice.member.exhibition.vo.out;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class GetExhibitionsResponseVo {

    private final Long exhibitionId;
    private final String name;
    private final String description;
    private final String rewardType;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String imageUrl;
}
