package com.promptoven.exhibitionservice.member.exhibition.vo.out;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class GetExhibitionDetailResponseVo {

    private final Long id;
    private final String name;
    private final String description;
    private final String rewardType;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final List<Long> exhibitionProductIds;
}
