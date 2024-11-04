package com.promptoven.exhibitionservice.member.exhibition.application;

import com.promptoven.exhibitionservice.global.common.CursorPage;
import com.promptoven.exhibitionservice.member.exhibition.dto.in.GetExhibitionsRequestDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetBannerResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionDetailResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionsResponseDto;

import java.util.List;

public interface ExhibitionService {

    CursorPage<GetExhibitionsResponseDto> getExhibitionsByDate(GetExhibitionsRequestDto requestDto);

    GetExhibitionDetailResponseDto getExhibitionDetail(Long exhibitionId);

    List<GetBannerResponseDto> getBanners(Long exhibitionId);
}
