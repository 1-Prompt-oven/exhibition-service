package com.promptoven.exhibitionservice.member.exhibition.application;

import com.promptoven.exhibitionservice.common.domain.Banner;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import com.promptoven.exhibitionservice.global.common.CursorPage;
import com.promptoven.exhibitionservice.global.common.response.BaseResponseStatus;
import com.promptoven.exhibitionservice.global.error.BaseException;
import com.promptoven.exhibitionservice.member.exhibition.dto.in.GetExhibitionsRequestDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetBannerResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionDetailResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionsResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.infrastructure.BannerRepository;
import com.promptoven.exhibitionservice.member.exhibition.infrastructure.ExhibitionProductRepository;
import com.promptoven.exhibitionservice.member.exhibition.infrastructure.ExhibitionRepository;
import com.promptoven.exhibitionservice.member.exhibition.infrastructure.ExhibitionRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExhibitionServiceImpl implements ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;
    private final BannerRepository bannerRepository;
    private final ExhibitionProductRepository exhibitionProductRepository;
    private final ExhibitionRepositoryCustom exhibitionRepositoryCustom;

    @Transactional(readOnly = true)
    public CursorPage<GetExhibitionsResponseDto> getExhibitionsByDate(GetExhibitionsRequestDto requestDto) {

        return exhibitionRepositoryCustom.getExhibitionsByDate(requestDto);
    }

    @Transactional(readOnly = true)
    @Override
    public GetExhibitionDetailResponseDto getExhibitionDetail(Long exhibitionId) {
        // exhibitionId에 해당하는 기획전 조회
        Exhibition exhibition = exhibitionRepository.findById(exhibitionId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.EXHIBITION_NOT_FOUND));

        // 기획전 상품 Id 조회
        List<Long> productIds = exhibitionProductRepository.findProductIdsByExhibitionId(exhibitionId);

        return GetExhibitionDetailResponseDto.fromEntity(exhibition, productIds);
    }

    @Transactional(readOnly = true)
    @Override
    public List<GetBannerResponseDto> getBanners(Long exhibitionId) {
        // exhibitionId에 해당하는 기획전 조회
        Exhibition exhibition = exhibitionRepository.findById(exhibitionId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.EXHIBITION_NOT_FOUND));

        // exhibitionId에 해당하는 모든 Banner 조회
        List<Banner> banners = bannerRepository.findAllByExhibitionId(exhibitionId);

        return banners.stream()
                .map(GetBannerResponseDto::fromEntity)
                .toList();
    }
}
