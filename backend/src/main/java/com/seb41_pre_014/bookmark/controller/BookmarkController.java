package com.seb41_pre_014.bookmark.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {

    //북마크 추가, 삭제

    @PostMapping
    public ResponseEntity postBookmark() {return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookmark-id}")
    public ResponseEntity deleteBookmark() {
        return ResponseEntity.noContent().build();
    }


}
