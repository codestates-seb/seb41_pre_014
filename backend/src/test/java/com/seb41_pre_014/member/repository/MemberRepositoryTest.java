package com.seb41_pre_014.member.repository;

import com.seb41_pre_014.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static com.seb41_pre_014.member.entity.Member.MemberStatus.MEMBER_ACTIVE;
import static com.seb41_pre_014.member.entity.Member.MemberStatus.MEMBER_SLEEP;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void createMember() throws Exception {
        // given
        Member member = createMember1();

        // when
        Member saveMember = memberRepository.save(member);

        // then
        assertNotNull(saveMember);
        assertNotNull(saveMember.getCreatedAt());
        assertNotNull(saveMember.getLastModifiedAt());
        assertEquals(member.getEmail(), saveMember.getEmail());
        assertEquals(member.getPassword(), saveMember.getPassword());
        assertEquals(member.getMemberStatus(), saveMember.getMemberStatus());
    }

    @Test
    void findMember() throws Exception {
        // given
        Member member = createMember1();
        Member saveMember = memberRepository.save(member);

        // when
        Member findMember = memberRepository.findById(saveMember.getMemberId()).get();

        // then
        assertEquals(saveMember.getMemberId(), findMember.getMemberId());
        assertEquals(saveMember.getMemberStatus(), findMember.getMemberStatus());
        assertEquals(saveMember.getEmail(), findMember.getEmail());
        assertEquals(saveMember.getPassword(), findMember.getPassword());
    }

    @Test
    void findMemberByEmail() throws Exception {
        // given
        Member member = createMember1();
        Member saveMember = memberRepository.save(member);

        // when
        Member findMember = memberRepository.findByEmail(saveMember.getEmail()).get();

        // then
        assertEquals(saveMember.getMemberId(), findMember.getMemberId());
        assertEquals(saveMember.getMemberStatus(), findMember.getMemberStatus());
        assertEquals(saveMember.getEmail(), findMember.getEmail());
        assertEquals(saveMember.getPassword(), findMember.getPassword());
    }

    @Test
    void findAll() throws Exception {
        // given
        Member member1 = createMember1();
        Member member2 = createMember2();
        memberRepository.save(member1);
        Member saveMember2 = memberRepository.save(member2);
        int page = 0;
        int size = 30;

        // when
        List<Member> members = memberRepository.findAll(PageRequest.of(page, size,
                Sort.by("memberId").descending())).getContent();

        // then
        assertEquals(2, members.size());
        assertEquals(saveMember2.getMemberId(), members.get(0).getMemberId());
    }


    @Test
    void deleteMember() throws Exception {
        // given
        Member member = createMember1();
        Member saveMember = memberRepository.save(member);

        // when
        memberRepository.deleteById(saveMember.getMemberId());

        // then
        assertEquals(Optional.empty(), memberRepository.findById(saveMember.getMemberId()));
    }



    public Member createMember1() {
        Member.MemberBuilder builder = Member.builder();
        builder.email("email1@gamil.com");
        builder.password("password1234!");
        builder.memberStatus(MEMBER_ACTIVE);
        return builder.build();
    }

    public Member createMember2() {
        Member.MemberBuilder builder = Member.builder();
        builder.email("email2@gamil.com");
        builder.password("password1234!");
        builder.memberStatus(MEMBER_ACTIVE);
        return builder.build();
    }

}