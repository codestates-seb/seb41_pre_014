package com.seb41_pre_014.vote.dto;

import com.seb41_pre_014.vote.entity.Vote;
import lombok.*;

public class VoteDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long voteId;
        private Long boardId;
        private String voter;
        private String voteType;

        @Builder
        public Response(Vote vote) {
            this.voteId = vote.getVoteId();
            this.boardId = vote.getBoard().getBoardId();
            this.voter = vote.getMember().getDisplayName();
            this.voteType = vote.getVoteType().name();
        }
    }
}
