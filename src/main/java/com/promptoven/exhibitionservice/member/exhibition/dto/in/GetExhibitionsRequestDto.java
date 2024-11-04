package com.promptoven.exhibitionservice.member.exhibition.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetExhibitionsRequestDto {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long lastId;
    private Integer pageSize;

    @Builder
    public GetExhibitionsRequestDto(LocalDateTime startDate, LocalDateTime endDate, Long lastId, Integer pageSize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastId = lastId;
        this.pageSize = pageSize;
    }
}
