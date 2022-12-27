package com.seb41_pre_014.vote.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vote extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    private Long boardId;
    private Long memberId;
    private VoteType voteType;

    public enum VoteType {
        UP("Up"),
        DOWN("Down");

        private String type;

        VoteType(String type) {
            this.type = type;
        }
    }
}
