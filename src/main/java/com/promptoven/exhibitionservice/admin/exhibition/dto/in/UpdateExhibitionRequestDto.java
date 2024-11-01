package com.promptoven.exhibitionservice.admin.exhibition.dto.in;

import com.promptoven.exhibitionservice.admin.exhibition.vo.in.UpdateExhibitionRequestVo;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class UpdateExhibitionRequestDto {

    private Long exhibitionId;
    private String name;
    private String description;
    private String rewardType;
    private LocalDateTime bannerStartDate;
    private LocalDateTime bannerEndDate;
    private boolean willShow;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<BannerInfo> bannerInfos;
    private List<Long> productIds;

    @Builder
    public UpdateExhibitionRequestDto(Long exhibitionId, String name, String description, String rewardType,
                                      LocalDateTime bannerStartDate, LocalDateTime bannerEndDate, boolean willShow,
                                      LocalDateTime startDate, LocalDateTime endDate,
                                      List<BannerInfo> bannerInfos, List<Long> productIds) {
        this.exhibitionId = exhibitionId;
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.bannerStartDate = bannerStartDate;
        this.bannerEndDate = bannerEndDate;
        this.willShow = willShow;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bannerInfos = bannerInfos;
        this.productIds = productIds;
    }

    public static UpdateExhibitionRequestDto toDto(UpdateExhibitionRequestVo vo) {
        return UpdateExhibitionRequestDto.builder()
                .exhibitionId(vo.getExhibitionId())
                .name(vo.getName())
                .description(vo.getDescription())
                .rewardType(vo.getRewardType())
                .bannerStartDate(vo.getBannerStartDate())
                .bannerEndDate(vo.getBannerEndDate())
                .willShow(vo.isWillShow())
                .startDate(vo.getStartDate())
                .endDate(vo.getEndDate())
                .bannerInfos(vo.getBannerInfos().stream()
                        .map(bannerInfo -> new BannerInfo(bannerInfo.getImageUrl(), bannerInfo.getBannerOrder()))
                        .collect(Collectors.toList()))
                .productIds(vo.getProductIds())
                .build();
    }

    public Exhibition toEntity() {
        return Exhibition.builder()
                .exhibitionId(this.exhibitionId) // 기존 id 유지
                .name(this.name)
                .description(this.description)
                .rewardType(this.rewardType)
                .bannerStartDate(this.bannerStartDate)
                .bannerEndDate(this.bannerEndDate)
                .willShow(this.willShow)
                .startDate(this.startDate)
                .endDate(this.endDate)
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
