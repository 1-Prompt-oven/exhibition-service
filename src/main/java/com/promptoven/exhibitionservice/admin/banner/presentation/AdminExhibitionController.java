package com.promptoven.exhibitionservice.admin.banner.presentation;

import com.promptoven.exhibitionservice.admin.banner.application.AdminExhibitionService;
import com.promptoven.exhibitionservice.admin.banner.dto.in.AddExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.banner.dto.in.DeleteExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.banner.dto.in.UpdateExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.banner.vo.in.AddExhibitionRequestVo;
import com.promptoven.exhibitionservice.admin.banner.vo.in.DeleteExhibitionRequestVo;
import com.promptoven.exhibitionservice.admin.banner.vo.in.UpdateExhibitionRequestVo;
import com.promptoven.exhibitionservice.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Tag(name = "기획전 관리 API", description = "기획전 관련 API endpoints")
@RequestMapping("/admin/exhibition")
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
    @DeleteMapping
    public BaseResponse<Void> deleteExhibition(@RequestBody DeleteExhibitionRequestVo deleteExhibitionRequestVo) {

        adminExhibitionService.deleteExhibition(DeleteExhibitionRequestDto.toDto(deleteExhibitionRequestVo));

        return new BaseResponse<>();
    }

}
