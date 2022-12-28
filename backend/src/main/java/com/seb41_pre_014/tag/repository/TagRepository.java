package com.seb41_pre_014.tag.repository;

import com.seb41_pre_014.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
