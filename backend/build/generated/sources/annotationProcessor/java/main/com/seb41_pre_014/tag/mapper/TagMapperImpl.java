package com.seb41_pre_014.tag.mapper;

import com.seb41_pre_014.tag.dto.TagDto.Post;
import com.seb41_pre_014.tag.dto.TagDto.Response;
import com.seb41_pre_014.tag.dto.TagDto.Response.ResponseBuilder;
import com.seb41_pre_014.tag.entity.Tag;
import com.seb41_pre_014.tag.entity.Tag.TagBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-01T19:29:40+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag tagPostDtoToTag(Post postDto) {
        if ( postDto == null ) {
            return null;
        }

        TagBuilder tag = Tag.builder();

        tag.name( postDto.getName() );

        return tag.build();
    }

    @Override
    public Response tagToResponseDto(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        ResponseBuilder response = Response.builder();

        response.tagId( tag.getTagId() );
        response.name( tag.getName() );

        return response.build();
    }

    @Override
    public List<Response> tagsToResponseDtos(List<Tag> tags) {
        if ( tags == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( tags.size() );
        for ( Tag tag : tags ) {
            list.add( tagToResponseDto( tag ) );
        }

        return list;
    }
}
