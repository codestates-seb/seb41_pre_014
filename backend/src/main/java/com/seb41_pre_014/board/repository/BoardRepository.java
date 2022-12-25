package com.seb41_pre_014.board.repository;

import com.seb41_pre_014.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 모든 Question 검색
    Page<Board> findAllByBoardTypeType(String boardType, Pageable pageable);

    // 제목 검색 기능
    Page<Board> findAllByTitleContaining(String keyword, Pageable pageable);

    // 제목 + 내용 검색 기능
    Page<Board> findAllByTitleAndBodyContaining(String keyword, Pageable pageable);

    // 답변 검색
    Page<Board> findAllByQuestionId(Long questionId, Pageable pageable);
}
