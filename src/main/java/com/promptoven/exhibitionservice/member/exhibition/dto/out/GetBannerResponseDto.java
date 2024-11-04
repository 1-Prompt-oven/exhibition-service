package com.promptoven.exhibitionservice.member.exhibition.dto.out;

import com.promptoven.exhibitionservice.common.domain.Banner;
import com.promptoven.exhibitionservice.member.exhibition.vo.out.GetBannerResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetBannerResponseDto {
    private Long bannerId;
    private Long exhibitionId;
    private String imageUrl;
    private int bannerOrder;

    @Builder
    public GetBannerResponseDto(Long bannerId, Long exhibitionId, String imageUrl, int bannerOrder) {
        this.bannerId = bannerId;
        this.exhibitionId = exhibitionId;
        this.imageUrl = imageUrl;
        this.bannerOrder = bannerOrder;
    }

    public static GetBannerResponseVo toVo(GetBannerResponseDto dto) {
        return GetBannerResponseVo.builder()
                .bannerId(dto.getBannerId())
                .exhibitionId(dto.getExhibitionId())
                .imageUrl(dto.getImageUrl())
                .bannerOrder(dto.getBannerOrder())
                .build();
    }

    public static GetBannerResponseDto fromEntity(Banner banner) {
        return GetBannerResponseDto.builder()
                .bannerId(banner.getId())
                .exhibitionId(banner.getExhibitionId())
                .imageUrl(banner.getImageUrl())
                .bannerOrder(banner.getBannerOrder())
                .build();
    }
}
