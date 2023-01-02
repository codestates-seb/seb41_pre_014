package com.seb41_pre_014.member.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.repository.BoardRepository;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.repository.MemberRepository;
import com.seb41_pre_014.tag.entity.MemberTag;
import com.seb41_pre_014.tag.entity.Tag;
import com.seb41_pre_014.tag.repository.TagRepository;
import com.seb41_pre_014.tag.service.TagService;
import com.seb41_pre_014.util.CustomAuthorityUtils;
import com.seb41_pre_014.util.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CustomBeanUtils<Member> beanUtils;
    private final BoardRepository boardRepository;
    private final TagRepository tagRepository;
    private final TagService tagService;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    @Transactional
    public Member createMember(Member member) {
        verfiyExistMember(member.getEmail());

        // Password 암호화
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // DB에 User Role 저장
        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);

        return memberRepository.save(member);
    }

    @Transactional
    public Member updateMember(Member member, List<String> tags) {
        Member findMember = findVerifiedMember(member.getMemberId());
        Member updateMember = beanUtils.copyNonNullProperties(member, findMember);
        if (tags != null) {
            List<Tag> findTags = tags.stream()
                    .map(tagService::findTagByName).collect(Collectors.toList());

            List<MemberTag> memberTags = new ArrayList<>();

            for (Tag tag : findTags) {
                memberTags.add(MemberTag.builder().tag(tag).member(updateMember).build());
            }
            updateMember.addMemberTags(memberTags);
        }

        return updateMember;    }

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

    public Page<Tag> findTagsByMember(Long memberId, int page, int size) {
        findVerifiedMember(memberId);
        return tagRepository.findAllByMemberTagMemberMemberId(memberId,
                PageRequest.of(page - 1, size, Sort.by("tagId").descending()));
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

    @Transactional
    public void deleteMember(Long memberId) {
        findVerifiedMember(memberId);
        memberRepository.deleteById(memberId);
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
