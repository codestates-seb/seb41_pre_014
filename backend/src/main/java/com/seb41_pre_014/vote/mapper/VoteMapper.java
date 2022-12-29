package com.seb41_pre_014.vote.mapper;

import com.seb41_pre_014.vote.dto.VoteDto;
import com.seb41_pre_014.vote.entity.Vote;

import java.util.List;

public interface VoteMapper {
    VoteDto.Response voteToVoteResponseDto(Vote vote);

    List<VoteDto.Response> votesToVoteResponseDtos(List<Vote> votes);

}
