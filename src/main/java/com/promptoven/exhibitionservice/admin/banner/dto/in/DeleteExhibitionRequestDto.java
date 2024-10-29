package com.promptoven.exhibitionservice.admin.banner.dto.in;

import com.promptoven.exhibitionservice.admin.banner.vo.in.DeleteExhibitionRequestVo;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteExhibitionRequestDto {

    private Long exhibitionId;


    @Builder
    public DeleteExhibitionRequestDto(Long exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public static DeleteExhibitionRequestDto toDto(DeleteExhibitionRequestVo deleteExhibitionRequestVo) {
        return DeleteExhibitionRequestDto.builder()
                .exhibitionId(deleteExhibitionRequestVo.getExhibitionId())
                .build();
    }

    public static Exhibition toEntity(Exhibition exhibition) {
        return Exhibition.builder()
                .exhibitionId(exhibition.getExhibitionId())
                .exhibitionId(exhibition.getExhibitionId())
                .name(exhibition.getName())
                .description(exhibition.getDescription())
                .startDate(exhibition.getStartDate())
                .endDate(exhibition.getEndDate())
                .build();
    }
}
