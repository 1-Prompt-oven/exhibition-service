package com.promptoven.exhibitionservice.admin.banner.application;

import com.promptoven.exhibitionservice.admin.banner.dto.in.AddExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.banner.dto.in.DeleteExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.banner.dto.in.UpdateExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.banner.infrastructure.AdminExhibitionRepository;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import com.promptoven.exhibitionservice.global.common.response.BaseResponseStatus;
import com.promptoven.exhibitionservice.global.error.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminExhibitionServiceImpl implements AdminExhibitionService {

    private final AdminExhibitionRepository adminExhibitionRepository;

    @Override
    public void addExhibition(AddExhibitionRequestDto exhibitionRequestDto) {

        if (Boolean.TRUE.equals(adminExhibitionRepository.existsByName(exhibitionRequestDto.getName()))) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_EXHIBITION_NAME);
        }

        adminExhibitionRepository.save(exhibitionRequestDto.toEntity());
    }

    @Override
    public void updateExhibition(UpdateExhibitionRequestDto updateExhibitionRequestDto) {

        adminExhibitionRepository.findById(updateExhibitionRequestDto.getExhibitionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.EXHIBITION_NOT_FOUND));

        adminExhibitionRepository.save(updateExhibitionRequestDto.toEntity());

    }

    @Override
    public void deleteExhibition(DeleteExhibitionRequestDto deleteExhibitionRequestDto) {

        Exhibition exhibition = adminExhibitionRepository.findById(deleteExhibitionRequestDto.getExhibitionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.EXHIBITION_NOT_FOUND));

        adminExhibitionRepository.save(DeleteExhibitionRequestDto.toEntity(exhibition));

    }

}
