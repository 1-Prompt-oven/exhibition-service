package com.promptoven.exhibitionservice.member.exhibition.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetBannerResponseVo {
    private Long bannerId;
    private Long exhibitionId;
    private String imageUrl;
    private int bannerOrder;

    @Builder
    public GetBannerResponseVo(Long bannerId, Long exhibitionId, String imageUrl, int bannerOrder) {
        this.bannerId = bannerId;
        this.exhibitionId = exhibitionId;
        this.imageUrl = imageUrl;
        this.bannerOrder = bannerOrder;
    }
}
