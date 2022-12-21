package com.seb41_pre_014.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @PostMapping
    public ResponseEntity postBoard() {
        return ResponseEntity.created(null).build();
    }

    @PatchMapping("/{board-id}")
    public ResponseEntity updateBoard() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{board-id}")
    public ResponseEntity findBoard() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/questions")
    public ResponseEntity findAllByQuestion() {
        return ResponseEntity.ok(null);
    }

    // 답변이 없는 순으로 정렬
    @GetMapping("/unanswered")
    public ResponseEntity findAllByAnswerCount() {
        return ResponseEntity.ok(null);
    }

    // 조회수 순으로 정렬
    @GetMapping("/frequent")
    public ResponseEntity findAllByViewCount() {
        return ResponseEntity.ok(null);
    }

    // 높은 점수순으로 정렬
    @GetMapping("/score")
    public ResponseEntity findAllByScore() {
        return ResponseEntity.ok(null);
    }

    // 검색어 기준 게시물 조회
    @GetMapping("/search")
    public ResponseEntity findAllBySearch() {
        return ResponseEntity.ok(null);
    }

    // 최신 답변순으로 정렬
    @GetMapping("/{board-id}/answers/newest")
    public ResponseEntity findAnswers() {
        return ResponseEntity.ok(null);
    }

    // 오래된 답변순으로 정렬
    @GetMapping("/{board-id}/answers/oldest")
    public ResponseEntity findAnsersByold() {
        return ResponseEntity.ok(null);
    }

    // 높은 점수순으로 답변 정렬
    @GetMapping("/{board-id}/answers/score")
    public ResponseEntity findAnswersByScore() {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("{board-id}")
    public ResponseEntity deleteBoard() {
        return ResponseEntity.noContent().build();
    }
}
