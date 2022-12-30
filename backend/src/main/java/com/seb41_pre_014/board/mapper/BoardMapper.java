package com.seb41_pre_014.board.mapper;

import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.board.entity.Board;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board boardPostDtoToBoard(BoardDto.Post boardPostDto);

    Board boardPatchDtoToBoard(BoardDto.Patch boardPatchDto);

    default BoardDto.Response boardToBoardResponseDto(Board board) {
        BoardDto.Response.ResponseBuilder response = BoardDto.Response.builder();

        response.board(board);

        return response.build();
    }

    List<BoardDto.Response> boardsToBoardResponseDtos(List<Board> boards);
}
