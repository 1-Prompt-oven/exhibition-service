package com.promptoven.exhibitionservice.admin.exhibition.vo.in;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class AddExhibitionRequestVo {

    private final String name;
    private final String description;
    private final String rewardType;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final List<BannerInfo> bannerInfos; // 배너 이미지 URL과 순서 리스트
    private final List<Long> productIds; // 기획전 상품 ID 리스트

    @Builder
    @Getter
    public static class BannerInfo {

        private String imageUrl;

        private int bannerOrder;
    }
}
