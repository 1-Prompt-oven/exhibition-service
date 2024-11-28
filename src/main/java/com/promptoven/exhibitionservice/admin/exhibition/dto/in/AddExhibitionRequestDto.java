package com.promptoven.exhibitionservice.admin.exhibition.dto.in;

import com.promptoven.exhibitionservice.admin.exhibition.vo.in.AddExhibitionRequestVo;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class AddExhibitionRequestDto {
    
    private String name;
    private String description;
    private String rewardType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<BannerInfo> bannerInfos;
    private List<Long> productIds;

    public static AddExhibitionRequestDto toDto(AddExhibitionRequestVo addExhibitionRequestVo) {
        return AddExhibitionRequestDto.builder()
                .name(addExhibitionRequestVo.getName())
                .description(addExhibitionRequestVo.getDescription())
                .rewardType(addExhibitionRequestVo.getRewardType())
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
                .startDate(startDate)
                .endDate(endDate)
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
