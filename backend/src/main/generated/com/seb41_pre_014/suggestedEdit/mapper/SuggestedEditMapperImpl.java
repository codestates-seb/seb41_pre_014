package com.seb41_pre_014.suggestedEdit.mapper;

import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto.Patch;
import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto.Post;
import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto.Response;
import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto.Response.ResponseBuilder;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit.SuggestedEditBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-31T17:00:59+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class SuggestedEditMapperImpl implements SuggestedEditMapper {

    @Override
    public SuggestedEdit suggestedEditPostDtoToEdit(Post postDto) {
        if ( postDto == null ) {
            return null;
        }

        SuggestedEditBuilder suggestedEdit = SuggestedEdit.builder();

        suggestedEdit.title( postDto.getTitle() );
        suggestedEdit.body( postDto.getBody() );

        return suggestedEdit.build();
    }

    @Override
    public SuggestedEdit suggestedEditPatchDtoToEdit(Patch patchDto) {
        if ( patchDto == null ) {
            return null;
        }

        SuggestedEditBuilder suggestedEdit = SuggestedEdit.builder();

        suggestedEdit.title( patchDto.getTitle() );
        suggestedEdit.body( patchDto.getBody() );

        return suggestedEdit.build();
    }

    @Override
    public Response editToSuggestedEditResponseDto(SuggestedEdit suggestedEdit) {
        if ( suggestedEdit == null ) {
            return null;
        }

        ResponseBuilder response = Response.builder();

        response.suggestedEdit( suggestedEdit );

        return response.build();
    }

    @Override
    public List<Response> editsTosuggestedEditResponseDtos(List<SuggestedEdit> suggestedEdits) {
        if ( suggestedEdits == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( suggestedEdits.size() );
        for ( SuggestedEdit suggestedEdit : suggestedEdits ) {
            list.add( editToSuggestedEditResponseDto( suggestedEdit ) );
        }

        return list;
    }
}
