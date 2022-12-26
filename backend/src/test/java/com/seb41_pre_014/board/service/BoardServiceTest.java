package com.seb41_pre_014.board.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.repository.BoardRepository;
import com.seb41_pre_014.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.seb41_pre_014.board.entity.Board.BoardType.QUESTION;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    @DisplayName("Question 생성")
    void postQuestion() {
        // given
        Board board = createBoard();
        given(boardRepository.save(Mockito.any(Board.class))).willReturn(board);

        // when
        Board postBoard = boardService.postQuestion(board);

        // then
        assertEquals(board.getTitle(), postBoard.getTitle());
    }

    @Test
    @DisplayName("Answer 생성")
    void postAnswer() {
        // given
        Board board = createBoard();
        given(boardRepository.save(Mockito.any(Board.class))).willReturn(board);

        // when
        Board postBoard = boardService.postAnswer(board);

        // then
        assertEquals(board.getTitle(), postBoard.getTitle());
    }

    @Test
    @DisplayName("findVerifiedBoard 테스트1")
    void updateBoard() {
        // given
        Board board = createBoard();
        given(boardRepository.findById(Mockito.anyLong())).willReturn(Optional.empty());

        // when // then
        assertThrows(RuntimeException.class, () -> boardService.updateBoard(board));
    }

    @Test
    @DisplayName("findVerifiedBoard 테스트2")
    void findBoard() {
        // given
        Long boardId = 1L;
        given(boardRepository.findById(Mockito.anyLong())).willReturn(Optional.empty());

        // when / then
        assertThrows(RuntimeException.class, () -> boardService.findBoard(boardId));
    }

    @Test
    @DisplayName("findVerifiedBoard 테스트3")
    void deleteBoard() {
        // given
        Long boardId = 1L;
        given(boardRepository.findById(Mockito.anyLong())).willReturn(Optional.empty());

        // when / then
        assertThrows(RuntimeException.class, () -> boardService.findBoard(boardId));
    }

    public Board createBoard() {
        Board.BoardBuilder builder = Board.builder();
        builder.boardId(1L);
        builder.writerDisplayName("홍길동1");
        builder.boardStatus(Board.BoardStatus.BOARD_PUBLIC);
        builder.boardType(QUESTION);
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        return builder.build();
    }
}