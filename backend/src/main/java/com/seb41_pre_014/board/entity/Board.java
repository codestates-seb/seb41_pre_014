package com.seb41_pre_014.board.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.tag.entity.BoardTag;
import com.seb41_pre_014.vote.entity.Vote;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    private Board question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Board> answers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", updatable = false)
    private Member member;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardTag> boardTags = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();

    public void addBookmarkCount() {
        this.bookmarkCount += 1;
    }

    public void addAnswerCount() {
        this.answerCount += 1;
    }

    public void subtractAnswerCount() {
        this.answerCount -= 1;
    }


    public void addAnswers(Board answer) {
        this.answers.add(answer);
    }

    public void subtractAnswers(Long answerId) {
        this.answers.remove(answerId);
    }

    public void addViewCount() {
        this.viewCount += 1;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setQuestion(Board question) {
        this.question = question;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public void chageStatus(BoardStatus boardStatus) {
        this.boardStatus = boardStatus;
    }

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
