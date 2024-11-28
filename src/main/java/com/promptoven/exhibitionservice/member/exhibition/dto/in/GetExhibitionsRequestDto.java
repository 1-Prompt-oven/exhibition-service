package com.promptoven.exhibitionservice.member.exhibition.dto.in;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class GetExhibitionsRequestDto {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long lastId;
    private Integer pageSize;
}
