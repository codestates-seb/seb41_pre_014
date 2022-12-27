package com.seb41_pre_014.board.repository;

import com.seb41_pre_014.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

    // 모든 Question 검색
    Page<Board> findAllByBoardType(Board.BoardType boardType, Pageable pageable);

    // 제목 검색 기능
    Page<Board> findAllByTitleContaining(String keyword, Pageable pageable);

    // Answer 검색
    Page<Board> findAllByQuestionId(Long questionId, Pageable pageable);

    // Member가 작성한 모든 Question 또는 Answer 조회
    Page<Board> findAllByMemberMemberIdAndBoardType(Long memberId, Board.BoardType boardType, Pageable pageable);

    // Member가 Bookmark한 모든 Board 조회
    Page<Board> findAllByBookmarksMemberMemberId(Long memberId, Pageable pageable);

    // Member가 Vote한 모든 Board 조회
    Page<Board> findAllByVotesMemberMemberId(Long memberId, Pageable pageable);
}
