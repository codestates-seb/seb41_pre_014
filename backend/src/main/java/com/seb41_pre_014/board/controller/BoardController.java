package com.seb41_pre_014.board.controller;

import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.mapper.BoardMapper;
import com.seb41_pre_014.board.service.BoardService;
import com.seb41_pre_014.tag.entity.BoardTag;
import com.seb41_pre_014.tag.entity.Tag;
import com.seb41_pre_014.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

import static com.seb41_pre_014.board.entity.Board.BoardType.ANSWER;
import static com.seb41_pre_014.board.entity.Board.BoardType.QUESTION;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper mapper;
    private final TagService tagService;

    @PostMapping("/questions")
    public ResponseEntity postQuestion(@RequestParam("memberId") @Positive Long memberId,
                                       @RequestBody @Valid BoardDto.Post postDto) {
        Board question = mapper.boardPostDtoToBoard(postDto);
        List<String> tags = postDto.getTags();

        Board postQuestion = boardService.postQuestion(memberId, question, tags);

        return new ResponseEntity<>(mapper.boardToBoardResponseDto(postQuestion), HttpStatus.CREATED);
    }

    @PostMapping("/answers/{question-id}")
    public ResponseEntity postAnswer(@PathVariable("question-id") @Positive Long questionId,
                                     @RequestParam("memberId") @Positive Long memberId,
                                     @RequestBody @Valid BoardDto.Post postDto) {
        Board answer = mapper.boardPostDtoToBoard(postDto);
        List<String> tags = postDto.getTags();

        Board postAnswer = boardService.postAnswer(questionId, memberId, answer, tags);


        return new ResponseEntity<>(mapper.boardToBoardResponseDto(postAnswer), HttpStatus.CREATED);
    }

    @PatchMapping("/{board-id}")
    public ResponseEntity updateBoard(@PathVariable("board-id") @Positive Long boardId,
                                      @RequestBody @Valid BoardDto.Patch patchDto) {
        Board board = mapper.boardPatchDtoToBoard(patchDto);
        List<String> tags = patchDto.getTags();
        board.setBoardId(boardId);
        Board updateBoard = boardService.updateBoard(board, tags);

        return new ResponseEntity<>(mapper.boardToBoardResponseDto(updateBoard), HttpStatus.OK);
    }

    @GetMapping("/{board-id}")
    public ResponseEntity findBoard(@PathVariable("board-id") @Positive Long boardId) {
        Board findBoard = boardService.findBoard(boardId);

        return ResponseEntity.ok(mapper.boardToBoardResponseDto(findBoard));
    }

    @GetMapping("/questions")
    public ResponseEntity findAllQuestions(@RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                           @RequestParam(value = "size", defaultValue = "30") @Positive int size) {
        List<Board> questions = boardService.findAllQuestions(page, size).getContent();

        return new ResponseEntity<>(mapper.boardsToBoardResponseDtos(questions), HttpStatus.OK);
    }

    // 답변이 없는 순으로 정렬
    @GetMapping("/unanswered")
    public ResponseEntity findAllByAnswerCount(@RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                               @RequestParam(value = "size", defaultValue = "30") @Positive int size) {
        List<Board> boards = boardService.findAllByAnswerCount(page, size).getContent();

        return new ResponseEntity<>(mapper.boardsToBoardResponseDtos(boards), HttpStatus.OK);
    }

    // 조회수 순으로 정렬
    @GetMapping("/frequent")
    public ResponseEntity findAllByViewCount(@RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                             @RequestParam(value = "size", defaultValue = "30") @Positive int size) {
        List<Board> boards = boardService.findAllByViewCount(page, size).getContent();

        return new ResponseEntity<>(mapper.boardsToBoardResponseDtos(boards), HttpStatus.OK);
    }

    // 높은 점수순으로 정렬
    @GetMapping("/score")
    public ResponseEntity findAllByScore(@RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                         @RequestParam(value = "size", defaultValue = "30") @Positive int size) {
        List<Board> boards = boardService.findAllByScore(page, size).getContent();

        return new ResponseEntity<>(mapper.boardsToBoardResponseDtos(boards), HttpStatus.OK);
    }

    // 검색어 기준 게시물 조회
    @GetMapping("/search")
    public ResponseEntity findAllBySearch(@RequestParam("keyword") String keyword,
                                          @RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                          @RequestParam(value = "size", defaultValue = "30") @Positive int size) {
        List<Board> boards = boardService.findAllBySearch(keyword, page, size).getContent();

        return new ResponseEntity<>(mapper.boardsToBoardResponseDtos(boards), HttpStatus.OK);
    }

    // 최신 답변순으로 정렬
    @GetMapping("answers/{question-id}/newest")
    public ResponseEntity findAnswersByDesc(@PathVariable("question-id") @Positive Long questionId,
                                            @RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                            @RequestParam(value = "size", defaultValue = "30") @Positive int size) {
        List<Board> answers = boardService.findAnswerByDesc(questionId, page, size).getContent();

        return new ResponseEntity<>(mapper.boardsToBoardResponseDtos(answers), HttpStatus.OK);
    }

    // 오래된 답변순으로 정렬
    @GetMapping("/answers/{question-id}/oldest")
    public ResponseEntity findAnsersByAsc(@PathVariable("question-id") @Positive Long questionId,
                                          @RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                          @RequestParam(value = "size", defaultValue = "30") @Positive int size) {
        List<Board> answers = boardService.findAnswerByAsc(questionId, page, size).getContent();

        return new ResponseEntity<>(mapper.boardsToBoardResponseDtos(answers), HttpStatus.OK);
    }

    // 높은 점수순으로 답변 정렬
    @GetMapping("/answers/{question-id}/score")
    public ResponseEntity findAnswersByScore(@PathVariable("question-id") @Positive Long questionId,
                                             @RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                             @RequestParam(value = "size", defaultValue = "30") @Positive int size) {
        List<Board> answers = boardService.findAnswersByScore(questionId, page, size).getContent();

        return new ResponseEntity<>(mapper.boardsToBoardResponseDtos(answers), HttpStatus.OK);
    }

    @DeleteMapping("/{board-id}")
    public ResponseEntity deleteBoard(@PathVariable("board-id") @Positive Long boardId) {
        boardService.deleteBoard(boardId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}