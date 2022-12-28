package com.seb41_pre_014.board.mapper;

import com.seb41_pre_014.board.dto.BoardDto.Patch;
import com.seb41_pre_014.board.dto.BoardDto.Post;
import com.seb41_pre_014.board.dto.BoardDto.Response;
import com.seb41_pre_014.board.dto.BoardDto.Response.ResponseBuilder;
import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.entity.Board.BoardBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T08:59:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class BoardMapperImpl implements BoardMapper {

    @Override
    public Board boardPostDtoToBoard(Post boardPostDto) {
        if ( boardPostDto == null ) {
            return null;
        }

        BoardBuilder board = Board.builder();

        board.title( boardPostDto.getTitle() );
        board.body( boardPostDto.getBody() );

        return board.build();
    }

    @Override
    public Board boardPatchDtoToBoard(Patch boardPatchDto) {
        if ( boardPatchDto == null ) {
            return null;
        }

        BoardBuilder board = Board.builder();

        board.title( boardPatchDto.getTitle() );
        board.body( boardPatchDto.getBody() );

        return board.build();
    }

    @Override
    public Response boardToResponseDto(Board board) {
        if ( board == null ) {
            return null;
        }

        ResponseBuilder response = Response.builder();

        response.boardId( board.getBoardId() );
        if ( board.getBoardType() != null ) {
            response.boardType( board.getBoardType().name() );
        }
        if ( board.getBoardStatus() != null ) {
            response.boardStatus( board.getBoardStatus().name() );
        }
        response.title( board.getTitle() );
        response.body( board.getBody() );
        response.score( board.getScore() );
        response.viewCount( board.getViewCount() );
        response.bookmarkCount( board.getBookmarkCount() );
        response.answerCount( board.getAnswerCount() );
        response.questionId( board.getQuestionId() );

        return response.build();
    }

    @Override
    public List<Response> boardsToResponseDtos(List<Board> boards) {
        if ( boards == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( boards.size() );
        for ( Board board : boards ) {
            list.add( boardToResponseDto( board ) );
        }

        return list;
    }
}
