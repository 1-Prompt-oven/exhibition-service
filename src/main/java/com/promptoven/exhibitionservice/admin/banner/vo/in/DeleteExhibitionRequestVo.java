package com.promptoven.exhibitionservice.admin.banner.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteExhibitionRequestVo {

    private Long exhibitionId;

    @Builder
    public DeleteExhibitionRequestVo(Long exhibitionId) {
        this.exhibitionId = exhibitionId;
    }
}
