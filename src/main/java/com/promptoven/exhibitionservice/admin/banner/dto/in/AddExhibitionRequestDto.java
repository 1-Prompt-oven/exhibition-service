package com.promptoven.exhibitionservice.admin.banner.dto.in;

import com.promptoven.exhibitionservice.admin.banner.vo.in.AddExhibitionRequestVo;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AddExhibitionRequestDto {
    private String name;
    private String description;
    private String rewardType;
    private LocalDateTime bannerStartDate;
    private LocalDateTime bannerEndDate;
    private boolean willShow;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Builder
    public AddExhibitionRequestDto(String name, String description, String rewardType,
                                   LocalDateTime bannerStartDate, LocalDateTime bannerEndDate, boolean willShow,
                                   LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.bannerStartDate = bannerStartDate;
        this.bannerEndDate = bannerEndDate;
        this.willShow = willShow;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static AddExhibitionRequestDto toDto(AddExhibitionRequestVo addExhibitionRequestVo) {
        return AddExhibitionRequestDto.builder()
                .name(addExhibitionRequestVo.getName())
                .description(addExhibitionRequestVo.getDescription())
                .rewardType(addExhibitionRequestVo.getRewardType())
                .bannerStartDate(addExhibitionRequestVo.getBannerStartDate())
                .bannerEndDate(addExhibitionRequestVo.getBannerEndDate())
                .willShow(addExhibitionRequestVo.isWillShow())
                .startDate(addExhibitionRequestVo.getStartDate())
                .endDate(addExhibitionRequestVo.getEndDate())
                .build();
    }

    public Exhibition toEntity() {
        return Exhibition.builder()
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
