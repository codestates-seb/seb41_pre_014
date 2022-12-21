package com.seb41_pre_014.vote.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vote {

    private Long voteId;
    private Long boardId;
    private Long memberId;
    private VoteType voteType;

    public enum VoteType {
        UP("up"),
        DOWN("down");

        private String type;

        VoteType(String type) {
            this.type = type;
        }
    }
}