package com.promptoven.exhibitionservice.member.exhibition.infrastructure;

import com.promptoven.exhibitionservice.common.domain.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
}
