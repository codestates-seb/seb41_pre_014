package com.seb41_pre_014.board.controller;

import com.seb41_pre_014.board.dto.BoardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @PostMapping
    public ResponseEntity postQuestion() {
        BoardDto.Response question = createQuestion();
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @PostMapping("/{question-id}")
    public ResponseEntity postAnswer() {
        BoardDto.Response answer = createAnswer();
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }

    @PatchMapping("/{board-id}")
    public ResponseEntity updateBoard() {
        BoardDto.Response question = createQuestion();
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping("/{board-id}")
    public ResponseEntity findBoard() {
        BoardDto.Response question = createQuestion();
        return ResponseEntity.ok(question);
    }

    @GetMapping("/questions")
    public ResponseEntity findAllByQuestion() {
        BoardDto.Response question = createQuestion();
        return ResponseEntity.ok(List.of(question));
    }

    // 답변이 없는 순으로 정렬
    @GetMapping("/unanswered")
    public ResponseEntity findAllByAnswerCount() {
        BoardDto.Response question = createQuestion();
        return ResponseEntity.ok(List.of(question));
    }

    // 조회수 순으로 정렬
    @GetMapping("/frequent")
    public ResponseEntity findAllByViewCount() {
        BoardDto.Response question = createQuestion();
        BoardDto.Response answer = createAnswer();
        BoardDto.Response answer2 = createAnswer2();
        return ResponseEntity.ok(List.of(question, answer, answer2));
    }

    // 높은 점수순으로 정렬
    @GetMapping("/score")
    public ResponseEntity findAllByScore() {
        BoardDto.Response question = createQuestion();
        BoardDto.Response answer = createAnswer();
        BoardDto.Response answer2 = createAnswer2();
        return ResponseEntity.ok(List.of(answer2, answer, question));
    }

    // 검색어 기준 게시물 조회
    @GetMapping("/search")
    public ResponseEntity findAllBySearch() {
        BoardDto.Response question = createQuestion();
        BoardDto.Response answer = createAnswer();
        return ResponseEntity.ok(List.of(question, answer));
    }

    // 최신 답변순으로 정렬
    @GetMapping("/{board-id}/answers/newest")
    public ResponseEntity findAnswers() {
        BoardDto.Response answer = createAnswer();
        BoardDto.Response answer2 = createAnswer2();
        return ResponseEntity.ok(List.of(answer, answer2));
    }

    // 오래된 답변순으로 정렬
    @GetMapping("/{board-id}/answers/oldest")
    public ResponseEntity findAnsersByold() {
        BoardDto.Response answer = createAnswer();
        BoardDto.Response answer2 = createAnswer2();
        return ResponseEntity.ok(List.of(answer, answer2));
    }

    // 높은 점수순으로 답변 정렬
    @GetMapping("/{board-id}/answers/score")
    public ResponseEntity findAnswersByScore() {
        BoardDto.Response answer = createAnswer();
        BoardDto.Response answer2 = createAnswer2();
        return ResponseEntity.ok(List.of(answer2, answer));
    }

    @DeleteMapping("{board-id}")
    public ResponseEntity deleteBoard() {
        return ResponseEntity.noContent().build();
    }

    public BoardDto.Response createQuestion() {
        BoardDto.Response.ResponseBuilder builder = BoardDto.Response.builder();
        builder.boardId(1L);
        builder.writerMemberId(1L);
        builder.writerReputation(10L);
        builder.writerProfileUrl("url");
        builder.writerDisplayName("홍길동1");
        builder.boardStatus("공개");
        builder.boardType("Question");
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        builder.tags(List.of("java", "react"));
        builder.score(10);
        builder.viewCount(1000);
        builder.answerCount(5);
        builder.bookmarkCount(20);
        builder.questionId(null);
        builder.answers(List.of(createAnswer(), createAnswer2()));
        BoardDto.Response response;
        response = builder.build();

        return response;
    }

    public BoardDto.Response createAnswer() {
        BoardDto.Response.ResponseBuilder builder = BoardDto.Response.builder();
        builder.boardId(2L);
        builder.writerMemberId(2L);
        builder.writerReputation(20L);
        builder.writerProfileUrl("url");
        builder.writerDisplayName("홍길동2");
        builder.boardStatus("임시저장");
        builder.boardType("Answer");
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        builder.tags(List.of("javascript"));
        builder.score(20);
        builder.viewCount(500);
        builder.answerCount(5);
        builder.bookmarkCount(30);
        builder.questionId(1L);
        BoardDto.Response response;
        response = builder.build();

        return response;
    }

    public BoardDto.Response createAnswer2() {
        BoardDto.Response.ResponseBuilder builder = BoardDto.Response.builder();
        builder.boardId(3L);
        builder.writerMemberId(3L);
        builder.writerReputation(20L);
        builder.writerProfileUrl("url");
        builder.writerDisplayName("홍길동2");
        builder.boardStatus("임시저장");
        builder.boardType("Answer");
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        builder.tags(List.of("javascript"));
        builder.score(40);
        builder.viewCount(200);
        builder.answerCount(3);
        builder.bookmarkCount(5);
        builder.questionId(1L);
        BoardDto.Response response;
        response = builder.build();

        return response;
    }
}
