package com.promptoven.exhibitionservice.member.exhibition.application;

import com.promptoven.exhibitionservice.common.domain.Banner;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionsResponseDto;
import com.promptoven.exhibitionservice.member.exhibition.infrastructure.BannerRepository;
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

    @Transactional(readOnly = true)
    @Override
    public List<GetExhibitionsResponseDto> getExhibitions() {

        List<Exhibition> exhibitions = exhibitionRepository.findAll();

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
}
