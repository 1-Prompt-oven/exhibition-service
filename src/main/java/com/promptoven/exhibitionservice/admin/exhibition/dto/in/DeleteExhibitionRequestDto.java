package com.promptoven.exhibitionservice.admin.exhibition.dto.in;

import com.promptoven.exhibitionservice.common.domain.Exhibition;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteExhibitionRequestDto {

    private Long exhibitionId;

    public static DeleteExhibitionRequestDto toDto(Long exhibitionId) {
        return DeleteExhibitionRequestDto.builder()
                .exhibitionId(exhibitionId)
                .build();
    }

    public static Exhibition toEntity(Exhibition exhibition) {
        return Exhibition.builder()
                .exhibitionId(exhibition.getExhibitionId())
                .name(exhibition.getName())
                .description(exhibition.getDescription())
                .rewardType(exhibition.getRewardType())
                .startDate(exhibition.getStartDate())
                .endDate(exhibition.getEndDate())
                .deleted(true)
                .build();
    }
}
