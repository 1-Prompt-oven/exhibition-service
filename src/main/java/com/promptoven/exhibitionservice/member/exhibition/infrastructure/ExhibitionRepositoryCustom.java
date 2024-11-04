package com.promptoven.exhibitionservice.member.exhibition.infrastructure;

import com.promptoven.exhibitionservice.global.common.CursorPage;
import com.promptoven.exhibitionservice.member.exhibition.dto.in.GetExhibitionsRequestDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionsResponseDto;

public interface ExhibitionRepositoryCustom {

    CursorPage<GetExhibitionsResponseDto> getExhibitionsByDate(GetExhibitionsRequestDto requestDto);
}

