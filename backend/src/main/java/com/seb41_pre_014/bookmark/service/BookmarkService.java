package com.seb41_pre_014.bookmark.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.repository.BoardRepository;
import com.seb41_pre_014.board.service.BoardService;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import com.seb41_pre_014.bookmark.repository.BookmarkRepository;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.repository.MemberRepository;
import com.seb41_pre_014.member.service.MemberService;
import com.seb41_pre_014.vote.entity.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final MemberService memberService;
    private final BoardService boardService;

    public Bookmark createBookmark(Long memberId, Long boardId) {
        Member member = memberService.findMember(memberId);
        Board board = boardService.findBoard(boardId);
        Bookmark bookmark = Bookmark.builder().member(member).board(board).build();

        return bookmarkRepository.save(bookmark);
    }

    public void deleteBookmark(Long bookmarkId) {
        bookmarkRepository.findById(bookmarkId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOOKMARK_NOT_FOUND));

        bookmarkRepository.deleteById(bookmarkId);
    }
}
