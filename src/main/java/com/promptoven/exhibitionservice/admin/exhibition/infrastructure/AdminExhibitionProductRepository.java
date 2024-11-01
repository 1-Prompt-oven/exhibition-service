package com.promptoven.exhibitionservice.admin.exhibition.infrastructure;

import com.promptoven.exhibitionservice.common.domain.ExhibitionProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminExhibitionProductRepository extends JpaRepository<ExhibitionProduct, Long> {
}
