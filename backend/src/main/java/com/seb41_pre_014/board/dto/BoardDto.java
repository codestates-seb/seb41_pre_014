package com.seb41_pre_014.board.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class BoardDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Post {

        @Size(min = 15, message = "Title must be at least 15 characters.")
        @NotBlank(message = "Title is missing.")
        private String title;

        @Size(min = 30, message = "Body must be at least 30 characters")
        @NotBlank(message = "Body is missing.")
        private String body;

        @NotNull(message = "Please enter at least one tag; see a list of popular tags.")
        private List<String> tags;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Patch {
        @Size(min = 15, message = "Title must be at least 15 characters.")
        @NotBlank(message = "Title is missing.")
        private String title;

        @Size(min = 30, message = "Body must be at least 30 characters")
        @NotBlank(message = "Body is missing.")
        private String body;

        @NotNull(message = "Please enter at least one tag; see a list of popular tags.")
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
        private List<Long> answers;
    }
}
