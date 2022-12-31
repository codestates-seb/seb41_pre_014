package com.seb41_pre_014.bookmark.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.service.BoardService;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import com.seb41_pre_014.bookmark.repository.BookmarkRepository;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final MemberService memberService;
    private final BoardService boardService;

    public Bookmark createBookmark(Long memberId, Long boardId) {
        Member member = memberService.findMember(memberId);
        Board board = boardService.findBoard(boardId);
        Bookmark bookmark = new Bookmark(member, board);
        Bookmark saveBookmark = bookmarkRepository.save(bookmark);
        board.setScore();

        return saveBookmark;
    }

    public void deleteBookmark(Long bookmarkId) {
        Bookmark bookmark = bookmarkRepository.findById(bookmarkId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOOKMARK_NOT_FOUND));
        Board board = bookmark.getBoard();

        bookmarkRepository.deleteById(bookmarkId);
        board.setScore();
    }
}
