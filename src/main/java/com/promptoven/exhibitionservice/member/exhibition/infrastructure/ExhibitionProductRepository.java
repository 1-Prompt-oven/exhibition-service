package com.promptoven.exhibitionservice.member.exhibition.infrastructure;

import com.promptoven.exhibitionservice.common.domain.ExhibitionProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExhibitionProductRepository extends JpaRepository<ExhibitionProduct, Long> {

    @Query("SELECT e.productId FROM ExhibitionProduct e WHERE e.exhibitionId = :exhibitionId")
    List<Long> findProductIdsByExhibitionId(@Param("exhibitionId") Long exhibitionId);
}
