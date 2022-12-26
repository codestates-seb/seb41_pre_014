package com.seb41_pre_014.board.repository;

import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.board.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.seb41_pre_014.board.entity.Board.BoardType.QUESTION;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("Board 생성")
    void postBoard() throws Exception {
        // given
        Board board = createQuestion();

        // when
        Board postBoard = boardRepository.save(board);

        // then
        assertNotNull(postBoard);
        assertNotNull(postBoard.getCreatedAt());
        assertNotNull(postBoard.getLastModifiedAt());
        assertEquals(board.getBoardStatus(), postBoard.getBoardStatus());
        assertEquals(board.getBoardType(), postBoard.getBoardType());
        assertEquals(board.getTitle(), postBoard.getTitle());
        assertEquals(board.getBody(), postBoard.getBody());
        assertEquals(board.getAnswerCount(), postBoard.getAnswerCount());
        assertEquals(board.getBookmarkCount(), postBoard.getBookmarkCount());
        assertEquals(board.getScore(), postBoard.getScore());
        assertEquals(board.getViewCount(), postBoard.getViewCount());
        assertEquals(board.getWriterMemberId(), postBoard.getWriterMemberId());
        assertEquals(board.getWriterDisplayName(), postBoard.getWriterDisplayName());
        assertEquals(board.getQuestionId(), postBoard.getQuestionId());
    }

    @Test
    @DisplayName("Board 수정")
    void updateBoard() throws Exception {
        // given
        Board board1 = createQuestion();
        Board postBoard = boardRepository.save(board1);
        Board board2 = Board.builder().boardId(postBoard.getBoardId()).boardStatus(Board.BoardStatus.BOARD_PRIVATE)
                .writerDisplayName("홍길동2").score(10).answerCount(10).bookmarkCount(10)
                .viewCount(10).build();
        boardRepository.save(board2);

        // when
        Board updateBoard = boardRepository.findById(board1.getBoardId()).get();

        // then
        assertEquals(board2.getBoardStatus(), updateBoard.getBoardStatus());
        assertEquals(board2.getWriterDisplayName(), updateBoard.getWriterDisplayName());
        assertEquals(board2.getScore(), updateBoard.getScore());
        assertEquals(board2.getAnswerCount(), updateBoard.getAnswerCount());
        assertEquals(board2.getBookmarkCount(), updateBoard.getBookmarkCount());
        assertEquals(board2.getViewCount(), updateBoard.getViewCount());
    }


    @Test
    @DisplayName("BoardId로 Board 조회")
    void findById() throws Exception {
        // given
        Board board = createQuestion();
        Board postBoard = boardRepository.save(board);

        // when
        Board findBoard = boardRepository.findById(postBoard.getBoardId()).get();

        // then
        assertNotNull(findBoard);
        assertNotNull(findBoard.getCreatedAt());
        assertNotNull(findBoard.getLastModifiedAt());
        assertEquals(board.getBoardStatus(), findBoard.getBoardStatus());
        assertEquals(board.getBoardType(), findBoard.getBoardType());
        assertEquals(board.getTitle(), findBoard.getTitle());
        assertEquals(board.getBody(), findBoard.getBody());
        assertEquals(board.getAnswerCount(), findBoard.getAnswerCount());
        assertEquals(board.getBookmarkCount(), findBoard.getBookmarkCount());
        assertEquals(board.getScore(), findBoard.getScore());
        assertEquals(board.getViewCount(), findBoard.getViewCount());
        assertEquals(board.getWriterMemberId(), findBoard.getWriterMemberId());
        assertEquals(board.getWriterDisplayName(), findBoard.getWriterDisplayName());
        assertEquals(board.getQuestionId(), findBoard.getQuestionId());
    }

    @Test
    @DisplayName("모든 Question 조회")
    void findAllByBoardType() throws Exception {
        // given
        Board question = createQuestion();
        Board answer = createAnswer();
        Board question2 = createQuestion();
        boardRepository.save(question);
        boardRepository.save(answer);
        boardRepository.save(question2);
        int page = 0;
        int size = 30;

        PageRequest pagerequest = PageRequest.of(page, size, Sort.by("boardId").descending());
        // when
        Page<Board> boardPage = boardRepository.findAllByBoardType(QUESTION, pagerequest);
        List<Board> content = boardPage.getContent();

        // then
        assertNotNull(content);
        assertEquals(2, content.size());
        assertEquals(3, content.get(0).getBoardId());
        assertEquals(QUESTION, content.get(0).getBoardType());
    }

    @Test
    @DisplayName("제목 검색으로 Board 조회")
    void findAllByTitleContaining() throws Exception {
        // given
        Board board1 = createQuestion();
        Board board2 = createAnswer();
        boardRepository.save(board1);
        boardRepository.save(board2);
        int page = 0;
        int size = 30;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("boardId").descending());

        // when
        List<Board> searchBoards1 = boardRepository.findAllByTitleContaining("What", pageRequest).getContent();
        List<Board> searchBoards2 = boardRepository.findAllByTitleContaining("?", pageRequest).getContent();

        // then
        assertEquals(1, searchBoards1.size());
        assertEquals(2, searchBoards2.size());
        assertTrue(searchBoards1.get(0).getTitle().contains("What"));
        assertTrue(searchBoards2.get(0).getTitle().contains("?"));
        assertTrue(searchBoards2.get(0).getTitle().contains("?"));
    }

    @Test
    @DisplayName("Board 삭제")
    public void deleteBoard() {
        // given
        Board board = createQuestion();
        Board postBoard = boardRepository.save(board);

        // when
        boardRepository.deleteById(postBoard.getBoardId());

        // then
        assertThrows(RuntimeException.class, () -> boardRepository.findById(postBoard.getBoardId()).get());
    }

    public Board createQuestion() {
        Board.BoardBuilder builder = Board.builder();
        builder.writerDisplayName("홍길동1");
        builder.boardStatus(Board.BoardStatus.BOARD_PUBLIC);
        builder.boardType(QUESTION);
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        return builder.build();
    }

    public Board createAnswer() {
        Board.BoardBuilder builder = Board.builder();
        builder.writerDisplayName("홍길동2");
        builder.boardStatus(Board.BoardStatus.BOARD_PUBLIC);
        builder.boardType(Board.BoardType.ANSWER);
        builder.title("Why do we use it?");
        builder.body("There are many variations of passages of Lorem Ipsum available");

        return builder.build();
    }
}