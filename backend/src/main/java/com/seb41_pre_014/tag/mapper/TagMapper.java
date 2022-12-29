package com.seb41_pre_014.tag.mapper;

import com.seb41_pre_014.tag.dto.TagDto;
import com.seb41_pre_014.tag.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag tagPostDtoToTag(TagDto.Post postDto);

    TagDto.Response tagToResponseDto(Tag tag);

    List<TagDto.Response> tagsToResponseDtos(List<Tag> tags);
}
