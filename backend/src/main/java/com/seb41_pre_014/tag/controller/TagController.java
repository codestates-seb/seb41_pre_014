package com.seb41_pre_014.tag.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {

    @PostMapping("/{tag-id}")
    public ResponseEntity postTag() {
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/{tag-id}")
    public ResponseEntity findTag() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllTag() {
        return ResponseEntity.ok().build();
    }


}
