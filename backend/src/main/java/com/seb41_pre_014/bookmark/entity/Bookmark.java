package com.seb41_pre_014.bookmark.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.vote.entity.Vote;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bookmark extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;


    public Bookmark(Member member, Board board) {
        this.member = member;
        this.board = board;
    }
}