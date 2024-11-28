package com.promptoven.exhibitionservice.member.exhibition.infrastructure;

import com.promptoven.exhibitionservice.common.domain.Banner;
import com.promptoven.exhibitionservice.common.domain.Exhibition;
import com.promptoven.exhibitionservice.common.domain.QExhibition;
import com.promptoven.exhibitionservice.global.common.CursorPage;
import com.promptoven.exhibitionservice.member.exhibition.dto.in.GetExhibitionsRequestDto;
import com.promptoven.exhibitionservice.member.exhibition.dto.out.GetExhibitionsResponseDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ExhibitionRepositoryImpl implements ExhibitionRepositoryCustom {

    private static final int DEFAULT_PAGE_SIZE = 20;
    private final JPAQueryFactory jpaQueryFactory;
    private final BannerRepository bannerRepository;

    @Override
    public CursorPage<GetExhibitionsResponseDto> getExhibitionsByDate(GetExhibitionsRequestDto requestDto) {
        QExhibition exhibition = QExhibition.exhibition;
        BooleanBuilder builder = new BooleanBuilder();

        LocalDateTime now = LocalDateTime.now();

        // startDate와 endDate가 null일 때 현재 날짜가 Exhibition의 기간에 포함된 항목만 조회
        if (requestDto.getStartDate() == null && requestDto.getEndDate() == null) {
            builder.and(exhibition.startDate.loe(now));
            builder.and(exhibition.endDate.goe(now));
        } else {
            // startDate와 endDate가 null이 아닐 때의 날짜 필터링
            LocalDateTime startDate = Optional.ofNullable(requestDto.getStartDate()).orElse(now.minusYears(1));
            LocalDateTime endDate = Optional.ofNullable(requestDto.getEndDate()).orElse(now);
            builder.and(exhibition.startDate.goe(startDate));
            builder.and(exhibition.endDate.loe(endDate));
        }

        // 삭제 되지 않은 기획전만 조회
        builder.and(exhibition.deleted.isFalse());

        int currentPageSize = Optional.ofNullable(requestDto.getPageSize()).orElse(DEFAULT_PAGE_SIZE);

        // Cursor 기반 조건 추가
        if (requestDto.getLastId() != null) {
            builder.and(exhibition.exhibitionId.gt(requestDto.getLastId()));
        }

        // QueryDSL 페이징 쿼리
        List<Exhibition> content = jpaQueryFactory
                .selectFrom(exhibition)
                .where(builder)
                .orderBy(exhibition.exhibitionId.asc())
                .limit(currentPageSize + 1)
                .fetch();

        Long nextCursor = null;
        boolean hasNext = false;

        // 페이징 처리
        if (content.size() > currentPageSize) {
            hasNext = true;
            content = content.subList(0, currentPageSize);
            nextCursor = content.get(currentPageSize - 1).getExhibitionId();
        }

        // 각 Exhibition에 맞는 banner의 imageUrl을 조회하여 DTO로 변환
        List<GetExhibitionsResponseDto> exhibitionDtos = content.stream()
                .map(exhibitionEntity -> {
                    String thumbnailUrl = bannerRepository.findByExhibitionIdAndBannerOrder(exhibitionEntity.getExhibitionId(), 0)
                            .map(Banner::getImageUrl)
                            .orElse(null);
                    return GetExhibitionsResponseDto.fromEntity(exhibitionEntity, thumbnailUrl);
                })
                .toList();

        return new CursorPage<>(exhibitionDtos, nextCursor, hasNext, currentPageSize, exhibitionDtos.size());
    }
}
