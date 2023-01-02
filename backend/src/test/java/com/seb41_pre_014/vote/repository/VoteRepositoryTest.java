package com.seb41_pre_014.vote.repository;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.vote.entity.Vote;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static com.seb41_pre_014.vote.entity.Vote.VoteType.DOWN;
import static com.seb41_pre_014.vote.entity.Vote.VoteType.UP;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VoteRepositoryTest {

    @Autowired
    private VoteRepository voteRepository;

    @Test
    @DisplayName("Vote 저장")
    void createVote() throws Exception {
        // given
        Vote vote = Vote.builder().voteType(UP).build();

        // when
        Vote saveVote = voteRepository.save(vote);

        // then
        assertNotNull(saveVote.getVoteId());
        assertEquals(vote.getVoteType(), saveVote.getVoteType());
        assertNotNull(saveVote.getCreatedAt());
        assertNotNull(saveVote.getLastModifiedAt());
    }

    @Test
    @DisplayName("Vote 수정")
    public void updateVote() throws Exception {
        // given
        Vote vote1 = Vote.builder().voteType(UP).build();
        Vote saveVote = voteRepository.save(vote1);
        Vote vote2 = Vote.builder().voteId(saveVote.getVoteId()).voteType(DOWN).build();

        // when
        voteRepository.save(vote2);
        Vote updateVote = voteRepository.findById(vote2.getVoteId()).get();

        // then
        assertEquals(updateVote.getVoteType(), DOWN);
    }

    @Test
    @DisplayName("Vote 조회")
    void findVote() throws Exception {
        // given
        Vote vote = Vote.builder().voteType(UP).build();
        Vote saveVote = voteRepository.save(vote);

        // when
        Vote findVote = voteRepository.findById(saveVote.getVoteId()).get();

        // then
        assertEquals(vote.getVoteType(), findVote.getVoteType());
    }

    @Test
    @DisplayName("모든 Vote 조회")
    void findAll() throws Exception {
        // given
        Vote vote1 = Vote.builder().voteType(UP).build();
        Vote vote2 = Vote.builder().voteType(DOWN).build();

        Vote saveVote1 = voteRepository.save(vote1);
        Vote saveVote2 = voteRepository.save(vote2);

        // when
        List<Vote> votes = voteRepository.findAll(Sort.by("voteId").descending());

        // then
        assertEquals(votes.get(0).getVoteId(), saveVote2.getVoteId());
        assertEquals(votes.get(0).getVoteType(), saveVote2.getVoteType());
        assertEquals(votes.get(1).getVoteId(), saveVote1.getVoteId());
        assertEquals(votes.get(1).getVoteType(), saveVote1.getVoteType());
        assertEquals(2, votes.size());
    }

    @Test
    void deleteVote() throws Exception {
        // given
        Vote vote = Vote.builder().voteType(UP).build();
        Vote saveVote = voteRepository.save(vote);

        // when
        voteRepository.deleteById(saveVote.getVoteId());

        // then
        assertEquals(voteRepository.findById(saveVote.getVoteId()), Optional.empty());
    }
}