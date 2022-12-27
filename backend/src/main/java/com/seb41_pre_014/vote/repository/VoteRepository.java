package com.seb41_pre_014.vote.repository;

import com.seb41_pre_014.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
