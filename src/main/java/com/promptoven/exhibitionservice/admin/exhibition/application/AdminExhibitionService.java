package com.promptoven.exhibitionservice.admin.exhibition.application;

import com.promptoven.exhibitionservice.admin.exhibition.dto.in.AddExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.exhibition.dto.in.DeleteExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.exhibition.dto.in.UpdateExhibitionRequestDto;

public interface AdminExhibitionService {

    void addExhibition(AddExhibitionRequestDto exhibitionRequestDto);

    void updateExhibition(UpdateExhibitionRequestDto exhibitionRequestDto);

    void deleteExhibition(DeleteExhibitionRequestDto exhibitionRequestDto);
}
