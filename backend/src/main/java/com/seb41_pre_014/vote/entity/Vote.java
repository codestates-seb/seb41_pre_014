package com.seb41_pre_014.vote.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vote extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private VoteType voteType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public enum VoteType {
        UP("Up"),
        DOWN("Down");

        private String type;

        VoteType(String type) {
            this.type = type;
        }
    }
}
