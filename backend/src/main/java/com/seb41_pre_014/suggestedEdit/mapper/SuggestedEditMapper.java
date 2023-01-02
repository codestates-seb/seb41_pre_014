package com.seb41_pre_014.suggestedEdit.mapper;

import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SuggestedEditMapper {
    SuggestedEdit suggestedEditPostDtoToEdit(SuggestedEditDto.Post postDto);

    SuggestedEdit suggestedEditPatchDtoToEdit(SuggestedEditDto.Patch patchDto);

    SuggestedEditDto.Response editToSuggestedEditResponseDto(SuggestedEdit suggestedEdit);

    List<SuggestedEditDto.Response> editsTosuggestedEditResponseDtos(List<SuggestedEdit> suggestedEdits);
}
