package com.promptoven.exhibitionservice.admin.exhibition.presentation;

import com.promptoven.exhibitionservice.admin.exhibition.application.AdminExhibitionService;
import com.promptoven.exhibitionservice.admin.exhibition.dto.in.AddExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.exhibition.dto.in.DeleteExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.exhibition.dto.in.UpdateExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.exhibition.vo.in.AddExhibitionRequestVo;
import com.promptoven.exhibitionservice.admin.exhibition.vo.in.UpdateExhibitionRequestVo;
import com.promptoven.exhibitionservice.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Tag(name = "기획전 관리자 API", description = "기획전 관련 API endpoints")
@RequestMapping("/v1/admin/exhibition")
public class AdminExhibitionController {

    private final AdminExhibitionService adminExhibitionService;

    @Operation(summary = "기획전 생성", description = "기획전 생성")
    @PostMapping
    public BaseResponse<Void> addExhibition(@RequestBody AddExhibitionRequestVo addExhibitionRequestVo) {

        adminExhibitionService.addExhibition(AddExhibitionRequestDto.toDto(addExhibitionRequestVo));

        return new BaseResponse<>();
    }

    @Operation(summary = "기획전 수정", description = "기획전 수정")
    @PutMapping
    public BaseResponse<Void> updateExhibition(@RequestBody UpdateExhibitionRequestVo updateExhibitionRequestVo) {

        adminExhibitionService.updateExhibition(UpdateExhibitionRequestDto.toDto(updateExhibitionRequestVo));

        return new BaseResponse<>();
    }

    @Operation(summary = "기획전 삭제", description = "기획전 삭제")
    @DeleteMapping({"/{exhibitionId}"})
    public BaseResponse<Void> deleteExhibition(@PathVariable Long exhibitionId) {

        adminExhibitionService.deleteExhibition(DeleteExhibitionRequestDto.toDto(exhibitionId));

        return new BaseResponse<>();
    }

}
