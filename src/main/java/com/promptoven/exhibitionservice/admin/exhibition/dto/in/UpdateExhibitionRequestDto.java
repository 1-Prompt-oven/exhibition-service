package com.promptoven.exhibitionservice.admin.exhibition.dto.in;

import com.promptoven.exhibitionservice.admin.exhibition.vo.in.UpdateExhibitionRequestVo;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class UpdateExhibitionRequestDto {

    private Long exhibitionId;
    private String name;
    private String description;
    private String rewardType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<BannerInfo> bannerInfos;
    private List<Long> productIds;

    public static UpdateExhibitionRequestDto toDto(UpdateExhibitionRequestVo vo) {
        return UpdateExhibitionRequestDto.builder()
                .exhibitionId(vo.getExhibitionId())
                .name(vo.getName())
                .description(vo.getDescription())
                .rewardType(vo.getRewardType())
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
                .startDate(this.startDate)
                .endDate(this.endDate)
                .deleted(false)
                .build();
    }

    @Builder
    @Getter
    public static class BannerInfo {

        private String imageUrl;

        private int bannerOrder;
    }
}
