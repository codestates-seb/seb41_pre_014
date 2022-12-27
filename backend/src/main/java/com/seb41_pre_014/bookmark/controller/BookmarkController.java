package com.seb41_pre_014.bookmark.controller;



import com.seb41_pre_014.bookmark.dto.BookmarkDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    //북마크 추가, 삭제
    @PostMapping
    public ResponseEntity postBookmark(@RequestParam("memberId") @Positive Long memberId,
                                       @RequestParam("boardId") @Positive Long boardId) {
        BookmarkDto.Response.ResponseBuilder builder = BookmarkDto.Response.builder();
        builder.bookmarkId(1L);
        builder.memberId(memberId);
        builder.boardId(boardId);
        BookmarkDto.Response response = builder.build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookmark-id}")
    public ResponseEntity deleteBookmark(@PathVariable("bookmark-id") @Positive Long bookmarkId) {
        return ResponseEntity.noContent().build();
    }


}
