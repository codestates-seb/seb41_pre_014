package com.seb41_pre_014.board.mapper;

import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.board.entity.Board;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board boardPostDtoToBoard(BoardDto.Post boardPostDto);

    Board boardPatchDtoToBoard(BoardDto.Patch boardPatchDto);

    BoardDto.Response boardToResponseDto(Board board);

    List<BoardDto.Response> boardsToResponseDtos(List<Board> boards);
}
