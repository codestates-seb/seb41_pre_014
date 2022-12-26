package com.seb41_pre_014.board.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.repository.BoardRepository;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.util.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CustomBeanUtils<Board> beanUtils;

    @Transactional
    public Board postQuestion(Board postQuestion) {
        return boardRepository.save(postQuestion);
    }

    @Transactional
    public Board postAnswer(Board postAnswer) {
        return boardRepository.save(postAnswer);
    }

    @Transactional
    public Board updateBoard(Board board) {
        Board findBoard = findVerifiedBoard(board.getBoardId());
        return beanUtils.copyNonNullProperties(board, findBoard);
    }

    public Board findBoard(Long boardId) {
        return findVerifiedBoard(boardId);
    }

    public Page<Board> findAllQuestions(int page, int size) {
        return boardRepository.findAllByBoardType(Board.BoardType.QUESTION,
                PageRequest.of(page - 1, size,
                        Sort.by("boardId").descending()));
    }

    public Page<Board> findAllByAnswerCount(int page, int size) {
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
        return boardRepository.findAllByQuestionId(questionId,
                PageRequest.of(page - 1, size, Sort.by("boardId").descending()));
    }

    public Page<Board> findAnswerByAsc(Long questionId, int page, int size) {
        return boardRepository.findAllByQuestionId(questionId,
                PageRequest.of(page - 1, size, Sort.by("boardId").ascending()));
    }

    public Page<Board> findAnswersByScore(Long questionId, int page, int size) {
        return boardRepository.findAllByQuestionId(questionId,
                PageRequest.of(page - 1, size, Sort.by("score").descending()));
    }

    public void deleteBoard(Long boardId) {
        findVerifiedBoard(boardId);
        boardRepository.deleteById(boardId);
    }

    public Board findVerifiedBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }
}
