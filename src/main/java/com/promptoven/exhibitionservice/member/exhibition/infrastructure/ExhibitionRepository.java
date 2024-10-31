package com.promptoven.exhibitionservice.member.exhibition.infrastructure;

import com.promptoven.exhibitionservice.common.domain.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

    List<Exhibition> findAllByDeletedFalse();
}
