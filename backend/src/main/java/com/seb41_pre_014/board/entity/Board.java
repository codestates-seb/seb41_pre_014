package com.seb41_pre_014.board.entity;

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
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private Long writerMemberId;
    private String writerDisplayName;
    private BoardType boardType;
    private BoardStatus boardStatus;
    private String title;
    private String body;
    private int score = 0;
    private int viewCount = 0;
    private int bookmarkCount = 0;
    private int answerCount = 0;
    private Long questionId;

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
