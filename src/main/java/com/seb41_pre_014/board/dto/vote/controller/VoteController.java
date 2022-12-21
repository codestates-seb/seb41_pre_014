package com.seb41_pre_014.vote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @PostMapping
    public ResponseEntity postVote() {
        return ResponseEntity.created(null).build();
    }

    @PatchMapping("/{vote-id}")
    public ResponseEntity patchVote() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{vote-id}")
    public ResponseEntity getVote() {
        return ResponseEntity.ok(null);
    }

    @GetMapping()
    public ResponseEntity getVotes() {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{vote-id}")
    public ResponseEntity deleteVote() {
        return ResponseEntity.noContent().build();
    }
}
