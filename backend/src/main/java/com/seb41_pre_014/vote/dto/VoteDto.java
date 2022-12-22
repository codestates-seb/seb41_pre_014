package com.seb41_pre_014.vote.dto;

import lombok.*;

public class VoteDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long voteId;
        private Long memberId;
        private Long boardId;
        private String voteType;
    }
}
