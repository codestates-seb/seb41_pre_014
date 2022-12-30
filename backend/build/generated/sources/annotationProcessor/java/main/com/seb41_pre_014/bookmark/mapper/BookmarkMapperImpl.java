package com.seb41_pre_014.bookmark.mapper;

import com.seb41_pre_014.bookmark.dto.BookmarkDto.Response;
import com.seb41_pre_014.bookmark.dto.BookmarkDto.Response.ResponseBuilder;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-30T01:56:11+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class BookmarkMapperImpl implements BookmarkMapper {

    @Override
    public Response bookmarkToResponseDto(Bookmark bookmark) {
        if ( bookmark == null ) {
            return null;
        }

        ResponseBuilder response = Response.builder();

        response.bookmark( bookmark );

        return response.build();
    }
}
