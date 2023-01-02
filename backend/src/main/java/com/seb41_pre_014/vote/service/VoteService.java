package com.seb41_pre_014.vote.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.service.BoardService;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.service.MemberService;
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
    private final MemberService memberService;
    private final BoardService boardService;

    @Transactional
    public Vote createVote(Long memberId, Long boardId, String voteType) {
        Member member = memberService.findMember(memberId);
        Board board = boardService.findBoard(boardId);

        Vote vote = Vote.builder().member(member).board(board).build();
        vote.setVoteType(voteType);
        Vote saveVote = voteRepository.save(vote);
        board.setScore();

        return saveVote;
    }

    @Transactional
    public Vote updateVote(Long voteId) {
        Vote findVote = findVerifiedVote(voteId);
        findVote.changeVote();
        findVote.getBoard().setScore();

        return findVote;
    }

    public Vote findVote(Long voteId) {
        return findVerifiedVote(voteId);
    }

    public List<Vote> findAll() {
        return voteRepository.findAll(Sort.by("voteId").descending());
    }

    @Transactional
    public void deleteVote(Long voteId) {
        Vote findVote = findVerifiedVote(voteId);
        Board board = findVote.getBoard();
        voteRepository.deleteById(voteId);
        board.setScore();
    }
    public Vote findVerifiedVote(Long voteId) {
        return voteRepository.findById(voteId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.VOTE_NOT_FOUND));
    }
}
