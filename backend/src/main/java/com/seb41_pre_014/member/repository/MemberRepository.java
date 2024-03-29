package com.seb41_pre_014.member.repository;

import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.tag.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
