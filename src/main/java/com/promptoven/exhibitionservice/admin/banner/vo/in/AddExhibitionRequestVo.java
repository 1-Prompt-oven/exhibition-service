package com.promptoven.exhibitionservice.admin.banner.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AddExhibitionRequestVo {
    private String name;
    private String description;
    private String rewardType;
    private LocalDateTime bannerStartDate;
    private LocalDateTime bannerEndDate;
    private boolean willShow;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Builder
    public AddExhibitionRequestVo(String name, String description, String rewardType,
                                  LocalDateTime bannerStartDate, LocalDateTime bannerEndDate, boolean willShow,
                                  LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.description = description;
        this.rewardType = rewardType;
        this.bannerStartDate = bannerStartDate;
        this.bannerEndDate = bannerEndDate;
        this.willShow = willShow;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
