package com.seb41_pre_014.vote.service;

import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.vote.entity.Vote;
import com.seb41_pre_014.vote.repository.VoteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static com.seb41_pre_014.vote.entity.Vote.VoteType.UP;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class VoteServiceTest {

    @Mock
    private VoteRepository voteRepository;

    @InjectMocks
    private VoteService voteService;

    @Test
    @DisplayName("Vote 저장")
    void createVote() {
        // given
        Vote vote = Vote.builder().voteType(UP).build();
        given(voteRepository.save(Mockito.any(Vote.class))).willReturn(vote);

        // when
        Vote saveVote = voteService.createVote(1L, 1L, "Up");

        // then
        assertEquals(vote.getVoteType(), saveVote.getVoteType());
    }

    @Test
    @DisplayName("findVerifiedVote 테스트1")
    void updateVote() {
        // given
        Vote vote = Vote.builder().voteId(1L).voteType(UP).build();
        given(voteRepository.findById(Mockito.anyLong())).willReturn(Optional.empty());

        // when / then
        assertThrows(BusinessLogicException.class, () -> voteService.updateVote(vote.getVoteId()));
    }

    @Test
    @DisplayName("findVerifiedVote 테스트2")
    void findVote() {
        // given
        Long voteId = 1L;
        given(voteRepository.findById(Mockito.anyLong())).willReturn(Optional.empty());

        // when / then
        assertThrows(BusinessLogicException.class, () -> voteService.findVote(voteId));
    }

    @Test
    @DisplayName("findVerifiedVote 테스트3")
    void deleteVote() {
        // given
        Long voteId = 1L;
        given(voteRepository.findById(Mockito.anyLong())).willReturn(Optional.empty());

        // when / then
        assertThrows(BusinessLogicException.class, () -> voteService.findVote(voteId));
    }

    @Test
    @DisplayName("모든 Vote 조회")
    void findAll() {
        // given
        Vote vote = Vote.builder().voteId(1L).voteType(UP).build();
        List<Vote> votes = List.of(vote);
        given(voteRepository.findAll(Mockito.any(Sort.class))).willReturn(votes);

        // when
        List<Vote> findVotes = voteService.findAll();

        // then
        assertEquals(vote.getVoteId(), findVotes.get(0).getVoteId());
    }
}