package com.promptoven.exhibitionservice.member.exhibition.vo.out;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetBannerResponseVo {
    
    private final Long bannerId;
    private final Long exhibitionId;
    private final String imageUrl;
    private final int bannerOrder;
}
