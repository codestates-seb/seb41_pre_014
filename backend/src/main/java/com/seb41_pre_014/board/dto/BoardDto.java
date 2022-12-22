package com.seb41_pre_014.board.dto;

import com.seb41_pre_014.board.entity.Board;
import lombok.*;

import java.util.List;

public class BoardDto {

    @Getter
    public static class Post {
        private String writerDisplayName;
        private String title;
        private String body;
        private List<String> tag;
    }

    @Getter
    public static class Patch {
        private String title;
        private String body;
        private List<String> tags;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long boardId;
        private Long writerMemberId;
        private Long writerReputation;
        private String writerProfileUrl;
        private String writerDisplayName;
        private String boardType;
        private String boardStatus;
        private String title;
        private String body;
        private List<String> tags;
        private int score;
        private int viewCount;
        private int bookmarkCount;
        private int answerCount;
        private Long questionId;
        private List<BoardDto.Response> answers;
    }
}
