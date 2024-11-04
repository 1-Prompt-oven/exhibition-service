package com.promptoven.exhibitionservice.member.exhibition.presentation;


import com.promptoven.exhibitionservice.global.common.response.BaseResponse;
import com.promptoven.exhibitionservice.member.exhibition.application.ExhibitionService;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetBannerResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionDetailResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionsResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.vo.out.GetBannerResponseVo;
import com.promptoven.exhibitionservice.member.exhibition.vo.out.GetExhibitionDetailResponseVo;
import com.promptoven.exhibitionservice.member.exhibition.vo.out.GetExhibitionsResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "기획전 Member API", description = "기획전 관련 API endpoints")
@RequestMapping("/v1/exhibition")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    @Operation(summary = "기획전 리스트 조회", description = "기획전 리스트 조회")
    @GetMapping()
    public BaseResponse<List<GetExhibitionsResponseVo>> getExhibitions() {
        return new BaseResponse<>(
                exhibitionService.getExhibitions()
                        .stream()
                        .map(GetExhibitionsResponseDto::toVo)
                        .toList()
        );
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
