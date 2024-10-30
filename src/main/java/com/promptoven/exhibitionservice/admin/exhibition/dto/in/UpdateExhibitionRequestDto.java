package com.promptoven.exhibitionservice.admin.exhibition.dto.in;

import com.promptoven.exhibitionservice.admin.exhibition.vo.in.UpdateExhibitionRequestVo;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @Builder
    public UpdateExhibitionRequestDto(Long exhibitionId, String name, String description, String rewardType,
                                      LocalDateTime bannerStartDate, LocalDateTime bannerEndDate, boolean willShow,
                                      LocalDateTime startDate, LocalDateTime endDate) {
        this.exhibitionId = exhibitionId;
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.bannerStartDate = bannerStartDate;
        this.bannerEndDate = bannerEndDate;
        this.willShow = willShow;
        this.startDate = startDate;
        this.endDate = endDate;
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
                .build();
    }

    public Exhibition toEntity() {
        return Exhibition.builder()
                .exhibitionId(exhibitionId)
                .name(name)
                .description(description)
                .rewardType(rewardType)
                .bannerStartDate(bannerStartDate)
                .bannerEndDate(bannerEndDate)
                .willShow(willShow)
                .startDate(startDate)
                .endDate(endDate)
                .deleted(false)
                .build();
    }
}
