package com.seb41_pre_014.tag.controller;

import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.tag.dto.TagDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {

    @PostMapping
    public ResponseEntity postTag() {
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity findTag() {
        return ResponseEntity.ok().build();
    }


}
