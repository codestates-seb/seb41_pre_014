package com.seb41_pre_014.board.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.repository.BoardRepository;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.service.MemberService;
import com.seb41_pre_014.tag.entity.BoardTag;
import com.seb41_pre_014.tag.entity.MemberTag;
import com.seb41_pre_014.tag.entity.Tag;
import com.seb41_pre_014.tag.service.TagService;
import com.seb41_pre_014.util.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private final TagService tagService;

    @Transactional
    public Board postQuestion(Long memberId, Board postQuestion, List<String> tags) {
        Member findMember = memberService.findMember(memberId);
        postQuestion.setMember(findMember);
        postQuestion.chageStatus(BOARD_PUBLIC);
        postQuestion.setBoardType(QUESTION);
        Board saveBoard = boardRepository.save(postQuestion);

        if (tags != null) {
            List<Tag> findTags = tags.stream()
                    .map(tagService::findTagByName).collect(Collectors.toList());

            List<BoardTag> boardTags = new ArrayList<>();

            for (Tag tag : findTags) {
                boardTags.add(BoardTag.builder().tag(tag).board(saveBoard).build());
            }
            saveBoard.addBoardTags(boardTags);
        }

        return saveBoard;
    }

    @Transactional
    public Board postAnswer(Long questionId, Long memberId, Board postAnswer, List<String> tags) {
        Board findQuestion = findVerifiedBoard(questionId);
        Member findMember = memberService.findMember(memberId);

        postAnswer.setQuestion(findQuestion);
        postAnswer.setMember(findMember);
        postAnswer.setBoardType(ANSWER);
        postAnswer.chageStatus(BOARD_PUBLIC);
        Board saveAnswer = boardRepository.save(postAnswer);

        if (tags != null) {
            List<Tag> findTags = tags.stream()
                    .map(tagService::findTagByName).collect(Collectors.toList());

            List<BoardTag> boardTags = new ArrayList<>();

            for (Tag tag : findTags) {
                boardTags.add(BoardTag.builder().tag(tag).board(saveAnswer).build());
            }

            saveAnswer.addBoardTags(boardTags);
        }

        return saveAnswer;
    }

    @Transactional
    public Board updateBoard(Board board, List<String> tags) {
        Board findBoard = findVerifiedBoard(board.getBoardId());
        Board updateBoard = beanUtils.copyNonNullProperties(board, findBoard);

        if (tags != null) {
            List<Tag> findTags = tags.stream()
                    .map(tagService::findTagByName).collect(Collectors.toList());

            List<BoardTag> boardTags = new ArrayList<>();

            for (Tag tag : findTags) {
                boardTags.add(BoardTag.builder().tag(tag).board(updateBoard).build());
            }

            updateBoard.addBoardTags(boardTags);
        }
        return updateBoard;
    }

    @Transactional
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
        findVerifiedBoard(boardId);

        boardRepository.deleteById(boardId);
    }

    public Board findVerifiedBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }
}
