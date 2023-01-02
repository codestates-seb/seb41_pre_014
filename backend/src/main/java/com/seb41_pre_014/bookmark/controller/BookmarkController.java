package com.seb41_pre_014.bookmark.controller;



import com.seb41_pre_014.bookmark.dto.BookmarkDto;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import com.seb41_pre_014.bookmark.mapper.BookmarkMapper;
import com.seb41_pre_014.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;
    private final BookmarkMapper mapper;

    //북마크 추가, 삭제
    @PostMapping
    public ResponseEntity postBookmark(@RequestParam("memberId") @Positive Long memberId,
                                       @RequestParam("boardId") @Positive Long boardId) {
        Bookmark postBookmark = bookmarkService.createBookmark(memberId, boardId);

        return new ResponseEntity<>(mapper.bookmarkToResponseDto(postBookmark), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookmark-id}")
    public ResponseEntity deleteBookmark(@PathVariable("bookmark-id") @Positive Long bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);

        return ResponseEntity.noContent().build();
    }
}
