package com.promptoven.exhibitionservice.member.exhibition.presentation;


import com.promptoven.exhibitionservice.global.common.CursorPage;
import com.promptoven.exhibitionservice.global.common.response.BaseResponse;
import com.promptoven.exhibitionservice.member.exhibition.application.ExhibitionService;
import com.promptoven.exhibitionservice.member.exhibition.dto.in.GetExhibitionsRequestDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetBannerResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionDetailResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionsResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.vo.out.GetBannerResponseVo;
import com.promptoven.exhibitionservice.member.exhibition.vo.out.GetExhibitionDetailResponseVo;
import com.promptoven.exhibitionservice.member.exhibition.vo.out.GetExhibitionsResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "기획전 Member API", description = "기획전 관련 API endpoints")
@RequestMapping("/v1/exhibition")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    @Operation(summary = "기획전 리스트 조회", description = "기획전 리스트 조회")
    @GetMapping
    public BaseResponse<CursorPage<GetExhibitionsResponseVo>> getExhibitionsByDate(
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate,
            @RequestParam(required = false) Long lastId,
            @RequestParam(required = false) Integer pageSize) {

        GetExhibitionsRequestDto requestDto = GetExhibitionsRequestDto.builder()
                .startDate(startDate)
                .endDate(endDate)
                .lastId(lastId)
                .pageSize(pageSize)
                .build();

        CursorPage<GetExhibitionsResponseDto> exhibitionsPage = exhibitionService.getExhibitionsByDate(requestDto);

        List<GetExhibitionsResponseVo> exhibitionsVos = exhibitionsPage.getContent().stream()
                .map(GetExhibitionsResponseDto::toVo)
                .toList();

        CursorPage<GetExhibitionsResponseVo> responsePage = new CursorPage<>(
                exhibitionsVos,
                exhibitionsPage.getNextCursor(),
                exhibitionsPage.getHasNext(),
                exhibitionsPage.getPageSize(),
                exhibitionsPage.getPage()
        );

        return new BaseResponse<>(responsePage);
    }


    @Operation(summary = "기획전 상세 조회", description = "기획전 상세 조회")
    @GetMapping("/{exhibitionId}")
    public BaseResponse<GetExhibitionDetailResponseVo> getExhibitionDetail(@PathVariable Long exhibitionId) {
        return new BaseResponse<>(GetExhibitionDetailResponseDto.toVo(exhibitionService.getExhibitionDetail(exhibitionId)));
    }

    @Operation(summary = "기획전 배너 조회", description = "기획전 배너 조회")
    @GetMapping("/banners/{exhibitionId}")
    public BaseResponse<List<GetBannerResponseVo>> getBanners(@PathVariable Long exhibitionId) {
        return new BaseResponse<>(
                exhibitionService.getBanners(exhibitionId)
                        .stream()
                        .map(GetBannerResponseDto::toVo)
                        .toList()
        );
    }

}
