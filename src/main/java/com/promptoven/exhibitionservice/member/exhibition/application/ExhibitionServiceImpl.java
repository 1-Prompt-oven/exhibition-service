package com.promptoven.exhibitionservice.member.exhibition.application;

import com.promptoven.exhibitionservice.common.domain.Banner;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import com.promptoven.exhibitionservice.global.common.response.BaseResponseStatus;
import com.promptoven.exhibitionservice.global.error.BaseException;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionDetailResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionsResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.infrastructure.BannerRepository;
import com.promptoven.exhibitionservice.member.exhibition.infrastructure.ExhibitionProductRepository;
import com.promptoven.exhibitionservice.member.exhibition.infrastructure.ExhibitionRepository;
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

    @Transactional(readOnly = true)
    @Override
    public List<GetExhibitionsResponseDto> getExhibitions() {

        // 삭제 되지 않은 기획전 모두 조회
        List<Exhibition> exhibitions = exhibitionRepository.findAllByDeletedFalse();

        return exhibitions.stream()
                .map(exhibition -> {
                    // exhibitionId가 일치하고 banner_order가 0인 Banner의 imageUrl 가져오기
                    String thumbnailUrl = bannerRepository.findByExhibitionIdAndBannerOrder(exhibition.getExhibitionId(), 0)
                            .map(Banner::getImageUrl)
                            .orElse(null); // 썸네일이 없는 경우 대비

                    // Exhibition과 thumbnailUrl을 이용해 DTO 생성
                    return GetExhibitionsResponseDto.fromEntity(exhibition, thumbnailUrl);
                })
                .toList();
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
}
