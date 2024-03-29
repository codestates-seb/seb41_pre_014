package com.seb41_pre_014.vote.mapper;

import com.seb41_pre_014.vote.dto.VoteDto.Response;
import com.seb41_pre_014.vote.dto.VoteDto.Response.ResponseBuilder;
import com.seb41_pre_014.vote.entity.Vote;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-01T19:29:40+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class VoteMapperImpl implements VoteMapper {

    @Override
    public Response voteToVoteResponseDto(Vote vote) {
        if ( vote == null ) {
            return null;
        }

        ResponseBuilder response = Response.builder();

        response.vote( vote );

        return response.build();
    }

    @Override
    public List<Response> votesToVoteResponseDtos(List<Vote> votes) {
        if ( votes == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( votes.size() );
        for ( Vote vote : votes ) {
            list.add( voteToVoteResponseDto( vote ) );
        }

        return list;
    }
}
