package com.seb41_pre_014.member.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.repository.BoardRepository;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.repository.MemberRepository;
import com.seb41_pre_014.util.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CustomBeanUtils<Member> beanUtils;
    private final BoardRepository boardRepository;

    public Member createMember(Member member) {
        verfiyExistMember(member.getEmail());
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId());
        return beanUtils.copyNonNullProperties(member, findMember);    }

    public Member findMember(Long memberId) {
        return findVerifiedMember(memberId);
    }

    public Page<Member> findAll(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page - 1, size,
                Sort.by("memberId").descending()));
    }

    public Page<Board> findQuestionsOrAnswersByMember(Long writerMemberId, Board.BoardType boardType, int page, int size) {
        findVerifiedMember(writerMemberId);
        return boardRepository.findAllByMemberMemberIdAndBoardType(writerMemberId, boardType,
                PageRequest.of(page - 1, size, Sort.by("boardId").descending()));
    }

    public Page<Board> findBoardsByBookmark(Long memberId, int page, int size) {
        findVerifiedMember(memberId);
        return boardRepository.findAllByBookmarksMemberMemberId(memberId,
                PageRequest.of(page - 1, size, Sort.by("boardId").descending()));
    }

    public Page<Board> findBoardsByVote(Long memberId, int page, int size) {
        findVerifiedMember(memberId);
        return boardRepository.findAllByVotesMemberMemberId(memberId,
                PageRequest.of(page - 1, size, Sort.by("boardId").descending()));
    }

    public void verfiyExistMember(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if (optionalMember.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXIST);
        }
    }

    public Member findVerifiedMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}
