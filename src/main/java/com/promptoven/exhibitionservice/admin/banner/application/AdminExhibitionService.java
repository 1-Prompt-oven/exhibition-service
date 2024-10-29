package com.promptoven.exhibitionservice.admin.banner.application;

import com.promptoven.exhibitionservice.admin.banner.dto.in.AddExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.banner.dto.in.DeleteExhibitionRequestDto;
import com.promptoven.exhibitionservice.admin.banner.dto.in.UpdateExhibitionRequestDto;

public interface AdminExhibitionService {

    void addExhibition(AddExhibitionRequestDto exhibitionRequestDto);

    void updateExhibition(UpdateExhibitionRequestDto exhibitionRequestDto);

    void deleteExhibition(DeleteExhibitionRequestDto exhibitionRequestDto);
}
