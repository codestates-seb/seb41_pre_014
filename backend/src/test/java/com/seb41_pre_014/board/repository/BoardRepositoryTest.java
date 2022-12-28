package com.seb41_pre_014.board.repository;

import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.repository.MemberRepository;
import com.seb41_pre_014.vote.entity.Vote;
import com.seb41_pre_014.vote.repository.VoteRepository;
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

import static com.seb41_pre_014.board.entity.Board.BoardType.ANSWER;
import static com.seb41_pre_014.board.entity.Board.BoardType.QUESTION;
import static com.seb41_pre_014.member.entity.Member.MemberStatus.MEMBER_ACTIVE;
import static com.seb41_pre_014.vote.entity.Vote.VoteType.UP;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private MemberRepository memberRepository;

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
        assertEquals(board.getQuestionId(), postBoard.getQuestionId());
    }

    @Test
    @DisplayName("Board 수정")
    void updateBoard() throws Exception {
        // given
        Board board1 = createQuestion();
        Board postBoard = boardRepository.save(board1);
        Board board2 = Board.builder().boardId(postBoard.getBoardId()).boardStatus(Board.BoardStatus.BOARD_PRIVATE)
                .viewCount(10).build();
        boardRepository.save(board2);

        // when
        Board updateBoard = boardRepository.findById(postBoard.getBoardId()).get();

        // then
        assertEquals(board2.getBoardStatus(), updateBoard.getBoardStatus());
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
    void findQuestionsByMember() throws Exception {
        // given
        Member saveMember1 = memberRepository.save(createMember1());
        Member saveMember2 = memberRepository.save(createMember2());
        Board question = createQuestion(saveMember1);
        Board answer = createAnswer(saveMember2);
        boardRepository.save(question);
        boardRepository.save(answer);
        int page = 0;
        int size = 30;
        Long memberId = 1L;
        Board.BoardType boardType = QUESTION;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("boardId").descending());

        // when
        List<Board> questions = boardRepository
                .findAllByMemberMemberIdAndBoardType(saveMember1.getMemberId(), boardType, pageRequest).getContent();

        // then
        assertEquals(1, questions.size());
        assertEquals(questions.get(0).getBoardType(), boardType);
    }

    @Test
    void findAnswersByMember() throws Exception {
        // given
        Member saveMember1 = memberRepository.save(createMember1());
        Member saveMember2 = memberRepository.save(createMember2());
        Board question = createQuestion(saveMember1);
        Board answer = createAnswer(saveMember2);
        boardRepository.save(question);
        boardRepository.save(answer);
        int page = 0;
        int size = 30;
        Board.BoardType boardType = ANSWER;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("boardId").descending());

        // when
        List<Board> questions = boardRepository
                .findAllByMemberMemberIdAndBoardType(saveMember2.getMemberId(), boardType, pageRequest).getContent();

        // then
        assertEquals(1, questions.size());
        assertEquals(questions.get(0).getBoardType(), boardType);
    }

    @Test
    void findBoardsByVote() throws Exception {
        // given
        Member member1 = createMember1();
        Member member2 = createMember2();
        Board question = createQuestion(member1);
        Board answer = createAnswer();
        Board saveBoard1 = boardRepository.save(question);
        Board saveBoard2 = boardRepository.save(answer);

        Member saveMember1 = memberRepository.save(member1);
        Member saveMember2 = memberRepository.save(member2);
        int page = 0;
        int size = 30;
        Vote vote1 = new Vote(null, UP, saveBoard1, saveMember1);
        Vote vote2 = new Vote(null, UP, saveBoard2, saveMember1);
        Vote vote3 = new Vote(null, UP, saveBoard2, saveMember2);

        voteRepository.save(vote1);
        voteRepository.save(vote2);
        voteRepository.save(vote3);

        // when
        List<Board> boards1 = boardRepository.findAllByVotesMemberMemberId(saveMember1.getMemberId(),
                PageRequest.of(page, size, Sort.by("boardId").descending())).getContent();
        List<Board> boards2 = boardRepository.findAllByVotesMemberMemberId(saveMember2.getMemberId(),
                PageRequest.of(page, size, Sort.by("boardId").descending())).getContent();
        // then
        assertEquals(2, boards1.size());
        assertEquals(1, boards2.size());
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
        builder.boardStatus(Board.BoardStatus.BOARD_PUBLIC);
        builder.boardType(QUESTION);
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        return builder.build();
    }

    public Board createAnswer() {
        Board.BoardBuilder builder = Board.builder();
        builder.boardStatus(Board.BoardStatus.BOARD_PUBLIC);
        builder.boardType(Board.BoardType.ANSWER);
        builder.title("Why do we use it?");
        builder.body("There are many variations of passages of Lorem Ipsum available");

        return builder.build();
    }

    public Board createQuestion(Member member) {
        Board.BoardBuilder builder = Board.builder();
        builder.member(member);
        builder.boardStatus(Board.BoardStatus.BOARD_PUBLIC);
        builder.boardType(QUESTION);
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        return builder.build();
    }

    public Board createAnswer(Member member) {
        Board.BoardBuilder builder = Board.builder();
        builder.member(member);
        builder.boardStatus(Board.BoardStatus.BOARD_PUBLIC);
        builder.boardType(Board.BoardType.ANSWER);
        builder.title("Why do we use it?");
        builder.body("There are many variations of passages of Lorem Ipsum available");

        return builder.build();
    }

    public Member createMember1() {
        Member.MemberBuilder builder = Member.builder();
        builder.email("email1@gamil.com");
        builder.password("password1234!");
        builder.memberStatus(MEMBER_ACTIVE);
        return builder.build();
    }

    public Member createMember2() {
        Member.MemberBuilder builder = Member.builder();
        builder.email("email2@gamil.com");
        builder.password("password1234!");
        builder.memberStatus(MEMBER_ACTIVE);
        return builder.build();
    }
}