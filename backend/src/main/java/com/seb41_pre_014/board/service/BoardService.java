package com.seb41_pre_014.board.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.repository.BoardRepository;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.service.MemberService;
import com.seb41_pre_014.util.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.seb41_pre_014.board.entity.Board.BoardStatus.BOARD_PUBLIC;
import static com.seb41_pre_014.board.entity.Board.BoardType.ANSWER;
import static com.seb41_pre_014.board.entity.Board.BoardType.QUESTION;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CustomBeanUtils<Board> beanUtils;
    private final MemberService memberService;

    @Transactional
    public Board postQuestion(Long memberId, Board postQuestion) {
        Member findMember = memberService.findMember(memberId);
        postQuestion.setMember(findMember);
        postQuestion.chageStatus(BOARD_PUBLIC);
        postQuestion.setBoardType(QUESTION);

        return boardRepository.save(postQuestion);
    }

    @Transactional
    public Board postAnswer(Long questionId, Long memberId, Board postAnswer) {
        Board findQuestion = findVerifiedBoard(questionId);
        Member findMember = memberService.findMember(memberId);

        postAnswer.setQuestion(findQuestion);
        postAnswer.setMember(findMember);
        postAnswer.setBoardType(ANSWER);
        postAnswer.chageStatus(BOARD_PUBLIC);

        Board saveAnswer = boardRepository.save(postAnswer);
        findQuestion.addAnswers(saveAnswer);
        findQuestion.addAnswerCount();

        return saveAnswer;
    }

    @Transactional
    public Board updateBoard(Board board) {
        Board findBoard = findVerifiedBoard(board.getBoardId());

        return beanUtils.copyNonNullProperties(board, findBoard);
    }

    public Board findBoard(Long boardId) {
        Board findBoard = findVerifiedBoard(boardId);
        findBoard.addViewCount();

        return findBoard;
    }

    public Page<Board> findAllQuestions(int page, int size) {
        return boardRepository.findAllByBoardType(QUESTION,
                PageRequest.of(page - 1, size,
                        Sort.by("boardId").descending()));
    }

    public Page<Board> findAllByAnswerCount(int page, int size) {
        return boardRepository.findAll(PageRequest.of(page - 1, size,
                Sort.by("answerCount")));
    }

    public Page<Board> findAllByViewCount(int page, int size) {
        return boardRepository.findAll(PageRequest.of(page - 1, size,
                Sort.by("viewCount").descending()));
    }

    public Page<Board> findAllByScore(int page, int size) {
        return boardRepository.findAll(PageRequest.of(page - 1, size,
                Sort.by("score").descending()));
    }

    public Page<Board> findAllBySearch(String keyword, int page, int size) {
        return boardRepository.findAllByTitleContaining(keyword, PageRequest.of(page - 1, size,
                Sort.by("boardId").descending()));
    }

    public Page<Board> findAnswerByDesc(Long questionId, int page, int size) {
        findVerifiedBoard(questionId);

        return boardRepository.findAllByQuestionBoardId(questionId,
                PageRequest.of(page - 1, size, Sort.by("boardId").descending()));
    }

    public Page<Board> findAnswerByAsc(Long questionId, int page, int size) {
        findVerifiedBoard(questionId);

        return boardRepository.findAllByQuestionBoardId(questionId,
                PageRequest.of(page - 1, size, Sort.by("boardId").ascending()));
    }

    public Page<Board> findAnswersByScore(Long questionId, int page, int size) {
        findVerifiedBoard(questionId);

        return boardRepository.findAllByQuestionBoardId(questionId,
                PageRequest.of(page - 1, size, Sort.by("score").descending()));
    }

    public void deleteBoard(Long boardId) {
        Board findBoard = findVerifiedBoard(boardId);

        if (findBoard.getBoardType() == ANSWER) {
            Board question = findBoard(boardId);
            question.subtractAnswers(boardId);
            question.subtractAnswerCount();
        }

        boardRepository.deleteById(boardId);
    }

    public Board findVerifiedBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }
}
