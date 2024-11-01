package com.promptoven.exhibitionservice.admin.exhibition.infrastructure;

import com.promptoven.exhibitionservice.common.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminBannerRepository extends JpaRepository<Banner, Long> {
    void deleteByExhibitionId(Long exhibitionId);
}
