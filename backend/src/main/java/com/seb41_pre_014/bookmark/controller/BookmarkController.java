package com.seb41_pre_014.bookmark.controller;



import com.seb41_pre_014.bookmark.dto.BookmarkDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {

    //북마크 추가, 삭제

    @PostMapping
    public ResponseEntity postBookmark() {
        BookmarkDto.Response.ResponseBuilder builder = BookmarkDto.Response.builder();
        builder.bookmarkId(1L);
        builder.memberId(1L);
        builder.boardId(1L);
        BookmarkDto.Response response = builder.build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookmark-id}")
    public ResponseEntity deleteBookmark() {
        return ResponseEntity.noContent().build();
    }


}
