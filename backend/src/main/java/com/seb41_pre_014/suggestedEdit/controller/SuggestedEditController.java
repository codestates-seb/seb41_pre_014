package com.seb41_pre_014.suggestedEdit.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suggested-edits")
public class SuggestedEditController {

    @PostMapping("/{edits-id}")
    public ResponseEntity postEdit() {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{edits-id}")
    public ResponseEntity findEdit() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity findAllEdit() { return new ResponseEntity(HttpStatus.OK);}
}
