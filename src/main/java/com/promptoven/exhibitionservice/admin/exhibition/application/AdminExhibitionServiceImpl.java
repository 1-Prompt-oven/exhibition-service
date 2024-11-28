package com.promptoven.exhibitionservice.admin.exhibition.application;

import com.promptoven.exhibitionservice.admin.exhibition.dto.in.AddExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.exhibition.dto.in.DeleteExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.exhibition.dto.in.UpdateExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.exhibition.infrastructure.AdminBannerRepository;
import com.promptoven.exhibitionservice.admin.exhibition.infrastructure.AdminExhibitionProductRepository;
import com.promptoven.exhibitionservice.admin.exhibition.infrastructure.AdminExhibitionRepository;
import com.promptoven.exhibitionservice.common.domain.Banner;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import com.promptoven.exhibitionservice.common.domain.ExhibitionProduct;
import com.promptoven.exhibitionservice.global.common.response.BaseResponseStatus;
import com.promptoven.exhibitionservice.global.error.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminExhibitionServiceImpl implements AdminExhibitionService {

    private final AdminExhibitionRepository adminExhibitionRepository;
    private final AdminBannerRepository adminBannerRepository;
    private final AdminExhibitionProductRepository adminExhibitionProductRepository;

    @Transactional
    @Override
    public void addExhibition(AddExhibitionRequestDto exhibitionRequestDto) {

        if (Boolean.TRUE.equals(adminExhibitionRepository.existsByName(exhibitionRequestDto.getName()))) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_EXHIBITION_NAME);
        }

        Exhibition exhibition = adminExhibitionRepository.save(exhibitionRequestDto.toEntity());

        // 배너 생성 및 저장
        List<Banner> banners = exhibitionRequestDto.getBannerInfos().stream()
                .map(bannerInfo -> Banner.builder()
                        .imageUrl(bannerInfo.getImageUrl())
                        .exhibitionId(exhibition.getExhibitionId())
                        .bannerOrder(bannerInfo.getBannerOrder())
                        .build())
                .toList();
        adminBannerRepository.saveAll(banners);

        // 상품 생성 및 저장
        List<ExhibitionProduct> products = exhibitionRequestDto.getProductIds().stream()
                .map(productId -> ExhibitionProduct.builder()
                        .exhibitionId(exhibition.getExhibitionId())
                        .productId(productId)
                        .build())
                .toList();
        adminExhibitionProductRepository.saveAll(products);
    }

    @Transactional
    @Override
    public void updateExhibition(UpdateExhibitionRequestDto updateExhibitionRequestDto) {
        // 기존 Exhibition 조회
        Exhibition existingExhibition = adminExhibitionRepository.findById(updateExhibitionRequestDto.getExhibitionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.EXHIBITION_NOT_FOUND));

        // DTO의 값을 가진 새로운 Exhibition 엔티티 생성 (Id 포함)
        Exhibition updatedExhibition = updateExhibitionRequestDto.toEntity();

        // 기존 값과 새로운 값을 비교하고 변경 사항 저장
        adminExhibitionRepository.save(updatedExhibition);

        // 기존 배너 삭제 후 새로운 배너 저장
        adminBannerRepository.deleteByExhibitionId(existingExhibition.getExhibitionId());
        List<Banner> banners = updateExhibitionRequestDto.getBannerInfos().stream()
                .map(bannerInfo -> Banner.builder()
                        .imageUrl(bannerInfo.getImageUrl())
                        .exhibitionId(existingExhibition.getExhibitionId())
                        .bannerOrder(bannerInfo.getBannerOrder())
                        .build())
                .toList();
        adminBannerRepository.saveAll(banners);

        // 기존 기획전 상품 삭제 후 새로운 상품 저장
        adminExhibitionProductRepository.deleteByExhibitionId(existingExhibition.getExhibitionId());
        List<ExhibitionProduct> products = updateExhibitionRequestDto.getProductIds().stream()
                .map(productId -> ExhibitionProduct.builder()
                        .exhibitionId(existingExhibition.getExhibitionId())
                        .productId(productId)
                        .build())
                .toList();
        adminExhibitionProductRepository.saveAll(products);
    }

    @Transactional
    @Override
    public void deleteExhibition(DeleteExhibitionRequestDto deleteExhibitionRequestDto) {

        Exhibition exhibition = adminExhibitionRepository.findById(deleteExhibitionRequestDto.getExhibitionId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.EXHIBITION_NOT_FOUND));

        adminExhibitionRepository.save(DeleteExhibitionRequestDto.toEntity(exhibition));
    }
}
