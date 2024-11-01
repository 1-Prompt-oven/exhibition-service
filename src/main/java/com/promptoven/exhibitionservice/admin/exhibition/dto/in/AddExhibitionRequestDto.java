package com.promptoven.exhibitionservice.admin.exhibition.dto.in;

import com.promptoven.exhibitionservice.admin.exhibition.vo.in.AddExhibitionRequestVo;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class AddExhibitionRequestDto {
    private String name;
    private String description;
    private String rewardType;
//    private LocalDateTime bannerStartDate;
//    private LocalDateTime bannerEndDate;
//    private boolean willShow;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<BannerInfo> bannerInfos;
    private List<Long> productIds;

    @Builder
    public AddExhibitionRequestDto(String name, String description, String rewardType,
//                                   LocalDateTime bannerStartDate, LocalDateTime bannerEndDate, boolean willShow,
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

    public static AddExhibitionRequestDto toDto(AddExhibitionRequestVo addExhibitionRequestVo) {
        return AddExhibitionRequestDto.builder()
                .name(addExhibitionRequestVo.getName())
                .description(addExhibitionRequestVo.getDescription())
                .rewardType(addExhibitionRequestVo.getRewardType())
//                .bannerStartDate(addExhibitionRequestVo.getBannerStartDate())
//                .bannerEndDate(addExhibitionRequestVo.getBannerEndDate())
//                .willShow(addExhibitionRequestVo.isWillShow())
                .startDate(addExhibitionRequestVo.getStartDate())
                .endDate(addExhibitionRequestVo.getEndDate())
                .bannerInfos(
                        addExhibitionRequestVo.getBannerInfos().stream()
                                .map(bannerInfo -> new AddExhibitionRequestDto.BannerInfo(
                                        bannerInfo.getImageUrl(),
                                        bannerInfo.getBannerOrder()
                                ))
                                .collect(Collectors.toList()))
                .productIds(addExhibitionRequestVo.getProductIds())
                .build();
    }

    public Exhibition toEntity() {
        return Exhibition.builder()
                .name(name)
                .description(description)
                .rewardType(rewardType)
//                .bannerStartDate(bannerStartDate)
//                .bannerEndDate(bannerEndDate)
//                .willShow(willShow)
                .startDate(startDate)
                .endDate(endDate)
                .deleted(false)
                .build();
    }

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
}
