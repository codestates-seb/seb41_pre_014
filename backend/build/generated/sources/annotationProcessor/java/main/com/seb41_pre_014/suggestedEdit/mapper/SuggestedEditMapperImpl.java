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
    date = "2022-12-29T23:19:22+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class SuggestedEditMapperImpl implements SuggestedEditMapper {

    @Override
    public SuggestedEdit editPostDtoToEdit(Post postDto) {
        if ( postDto == null ) {
            return null;
        }

        SuggestedEditBuilder suggestedEdit = SuggestedEdit.builder();

        suggestedEdit.title( postDto.getTitle() );
        suggestedEdit.body( postDto.getBody() );

        return suggestedEdit.build();
    }

    @Override
    public SuggestedEdit editPatchDtoToEdit(Patch patchDto) {
        if ( patchDto == null ) {
            return null;
        }

        SuggestedEditBuilder suggestedEdit = SuggestedEdit.builder();

        suggestedEdit.editId( patchDto.getEditId() );
        suggestedEdit.title( patchDto.getTitle() );
        suggestedEdit.boardId( patchDto.getBoardId() );
        suggestedEdit.editorId( patchDto.getEditorId() );
        suggestedEdit.body( patchDto.getBody() );

        return suggestedEdit.build();
    }

    @Override
    public Response editToEditResponseDto(SuggestedEdit suggestedEdit) {
        if ( suggestedEdit == null ) {
            return null;
        }

        ResponseBuilder response = Response.builder();

        response.editId( suggestedEdit.getEditId() );
        response.title( suggestedEdit.getTitle() );
        response.boardId( suggestedEdit.getBoardId() );
        response.editorId( suggestedEdit.getEditorId() );
        response.body( suggestedEdit.getBody() );

        return response.build();
    }

    @Override
    public List<Response> editsToEditResponseDtos(List<SuggestedEdit> suggestedEdits) {
        if ( suggestedEdits == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( suggestedEdits.size() );
        for ( SuggestedEdit suggestedEdit : suggestedEdits ) {
            list.add( editToEditResponseDto( suggestedEdit ) );
        }

        return list;
    }
}
