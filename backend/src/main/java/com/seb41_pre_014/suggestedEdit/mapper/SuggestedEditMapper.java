package com.seb41_pre_014.suggestedEdit.mapper;

import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SuggestedEditMapper {
    SuggestedEdit editPostDtoToEdit(SuggestedEditDto.Post postDto);

    SuggestedEdit editPatchDtoToEdit(SuggestedEditDto.Patch patchDto);

    SuggestedEditDto.Response editToEditResponseDto(SuggestedEdit suggestedEdit);

    List<SuggestedEditDto.Response> editsToEditResponseDtos(List<SuggestedEdit> suggestedEdits);
}
