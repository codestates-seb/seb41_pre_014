package com.seb41_pre_014.board.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import com.seb41_pre_014.vote.entity.Vote;
import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false, updatable = false)
    private Long writerMemberId;

    private String writerDisplayName;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private BoardType boardType;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private BoardStatus boardStatus;
    private String title;
    private String body;
    private int score = 0;
    private int viewCount = 0;
    private int bookmarkCount = 0;
    private int answerCount = 0;
    private Long questionId;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();

    public enum BoardType {
        QUESTION("Question"),
        ANSWER("Answer");

        @Getter
        private String type;

        BoardType(String type) {
            this.type = type;
        }
    }

    public enum BoardStatus {
        BOARD_PUBLIC("공개"),
        BOARD_PRIVATE("임시저장"),
        BOARD_DELETE("삭제");

        @Getter
        private String status;

        BoardStatus(String status) {
            this.status = status; }
    }
}
