package com.promptoven.exhibitionservice.admin.exhibition.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class AddExhibitionRequestVo {
    private String name;
    private String description;
    private String rewardType;
//    private LocalDateTime bannerStartDate;
//    private LocalDateTime bannerEndDate;
//    private boolean willShow;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<BannerInfo> bannerInfos; // 배너 이미지 URL과 순서 리스트
    private List<Long> productIds; // 기획전 상품 ID 리스트

    @Getter
    @NoArgsConstructor
    public static class BannerInfo {
        private String imageUrl;
        private int bannerOrder;

        @Builder
        public BannerInfo(String imageUrl, int bannerOrder) {
            this.imageUrl = imageUrl;
            this.bannerOrder = bannerOrder;
        }
    }

    @Builder
    public AddExhibitionRequestVo(String name, String description, String rewardType,
//                                  LocalDateTime bannerStartDate, LocalDateTime bannerEndDate, boolean willShow,
                                  LocalDateTime startDate, LocalDateTime endDate,
                                  List<BannerInfo> bannerInfos, List<Long> productIds) {
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
//        this.bannerStartDate = bannerStartDate;
//        this.bannerEndDate = bannerEndDate;
//        this.willShow = willShow;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bannerInfos = bannerInfos;
        this.productIds = productIds;
    }
}
