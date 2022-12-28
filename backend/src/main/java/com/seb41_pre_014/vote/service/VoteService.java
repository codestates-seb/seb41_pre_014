package com.seb41_pre_014.vote.service;

import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.util.CustomBeanUtils;
import com.seb41_pre_014.vote.entity.Vote;
import com.seb41_pre_014.vote.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final CustomBeanUtils<Vote> beanUtils;

    @Transactional
    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Transactional
    public Vote updateVote(Vote vote) {
        Vote findVote = findVerifiedVote(vote.getVoteId());

        return beanUtils.copyNonNullProperties(vote, findVote);
    }

    public Vote findVote(Long voteId) {
        return findVerifiedVote(voteId);
    }

    public List<Vote> findAll() {
        return voteRepository.findAll(Sort.by("voteId").descending());
    }

    @Transactional
    public void deleteVote(Long voteId) {
        findVerifiedVote(voteId);
        voteRepository.deleteById(voteId);
    }
    public Vote findVerifiedVote(Long voteId) {
        return voteRepository.findById(voteId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.VOTE_NOT_FOUND));
    }
}
