package com.seb41_pre_014.tag.repository;

import com.seb41_pre_014.tag.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Page<Tag> findAllByMemberTagMemberMemberId(Long memberId, Pageable pageable);

    Optional<Tag> findByName(String tagName);
}
