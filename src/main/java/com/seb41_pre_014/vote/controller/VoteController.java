package com.seb41_pre_014.vote.controller;

import com.seb41_pre_014.vote.dto.VoteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @PostMapping
    public ResponseEntity postVote() {
        VoteDto.Response.ResponseBuilder builder = VoteDto.Response.builder();
        builder.voteId(1L);
        builder.voteType("Up");
        builder.boardId(1L);
        builder.memberId(1L);
        VoteDto.Response response = builder.build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{vote-id}")
    public ResponseEntity patchVote() {
        VoteDto.Response.ResponseBuilder builder = VoteDto.Response.builder();
        builder.voteId(1L);
        builder.voteType("Down");
        builder.boardId(1L);
        builder.memberId(1L);
        VoteDto.Response response = builder.build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{vote-id}")
    public ResponseEntity getVote() {
        VoteDto.Response.ResponseBuilder builder = VoteDto.Response.builder();
        builder.voteId(1L);
        builder.voteType("Up");
        builder.boardId(1L);
        builder.memberId(1L);
        VoteDto.Response response = builder.build();
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity getVotes() {
        VoteDto.Response.ResponseBuilder builder = VoteDto.Response.builder();
        builder.voteId(1L);
        builder.voteType("Up");
        builder.boardId(1L);
        builder.memberId(1L);
        VoteDto.Response response1 = builder.build();
        VoteDto.Response response2 = builder.build();
        return ResponseEntity.ok(List.of(response1, response2));
    }

    @DeleteMapping("/{vote-id}")
    public ResponseEntity deleteVote() {
        return ResponseEntity.noContent().build();
    }
}
