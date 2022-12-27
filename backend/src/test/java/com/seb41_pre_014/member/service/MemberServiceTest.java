package com.seb41_pre_014.member.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.repository.BoardRepository;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static com.seb41_pre_014.board.entity.Board.BoardType.QUESTION;
import static com.seb41_pre_014.member.entity.Member.MemberStatus.MEMBER_ACTIVE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void createMember() throws Exception {
        // given
        Member member = createMember1();
        given(memberRepository.findByEmail(Mockito.anyString())).willReturn(Optional.ofNullable(null));
        given(memberRepository.save(Mockito.any(Member.class))).willReturn(member);

        // when
        Member saveMember = memberService.createMember(member);

        // then
        assertEquals(member.getEmail(), saveMember.getEmail());
    }

    @Test
    void verifiyExist() throws Exception {
        // given
        Member member = createMember1();
        given(memberRepository.findByEmail(Mockito.anyString())).willReturn(Optional.of(member));

        // when / then
        assertThrows(BusinessLogicException.class, () -> memberService.createMember(member));
    }


    public Member createMember1() {
        Member.MemberBuilder builder = Member.builder();
        builder.memberId(1L);
        builder.email("email1@gamil.com");
        builder.password("password1234!");
        builder.memberStatus(MEMBER_ACTIVE);
        return builder.build();
    }



    public Member createMember2() {
        Member.MemberBuilder builder = Member.builder();
        builder.memberId(1L);
        builder.email("email2@gamil.com");
        builder.password("password1234!");
        builder.memberStatus(MEMBER_ACTIVE);
        return builder.build();
    }

    public Board createQuestion() {
        Board.BoardBuilder builder = Board.builder();
        builder.boardStatus(Board.BoardStatus.BOARD_PUBLIC);
        builder.boardType(QUESTION);
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        return builder.build();
    }

}