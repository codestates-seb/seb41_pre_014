package com.seb41_pre_014.vote.controller;

import com.seb41_pre_014.vote.dto.VoteDto;
import com.seb41_pre_014.vote.entity.Vote;
import com.seb41_pre_014.vote.mapper.VoteMapper;
import com.seb41_pre_014.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;
    private final VoteMapper mapper;

    @PostMapping
    public ResponseEntity postVote(@RequestParam("memberId") @Positive Long memberId,
                                   @RequestParam("boardId") @Positive Long boardId,
                                   @RequestParam("voteType") String voteType) {
        Vote vote = voteService.createVote(memberId, boardId, voteType);

        return new ResponseEntity<>(mapper.voteToVoteResponseDto(vote), HttpStatus.CREATED);
    }

    @PatchMapping("/{vote-id}")
    public ResponseEntity patchVote(@PathVariable("vote-id") @Positive Long voteId) {
        Vote vote = voteService.updateVote(voteId);
        return ResponseEntity.ok(mapper.voteToVoteResponseDto(vote));
    }

    @GetMapping("/{vote-id}")
    public ResponseEntity getVote(@PathVariable("vote-id") @Positive Long voteId) {
        Vote findVote = voteService.findVote(voteId);

        return ResponseEntity.ok(mapper.voteToVoteResponseDto(findVote));
    }

    @GetMapping()
    public ResponseEntity getVotes() {
        List<Vote> voteAll = voteService.findAll();

        return ResponseEntity.ok(mapper.votesToVoteResponseDtos(voteAll));
    }

    @DeleteMapping("/{vote-id}")
    public ResponseEntity deleteVote(@PathVariable("vote-id") @Positive Long voteId) {
        voteService.deleteVote(voteId);
        return ResponseEntity.noContent().build();
    }
}
