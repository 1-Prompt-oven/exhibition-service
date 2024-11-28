package com.promptoven.exhibitionservice.admin.exhibition.vo.in;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteExhibitionRequestVo {

    private final Long exhibitionId;
}
