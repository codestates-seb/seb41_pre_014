package com.seb41_pre_014.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TagDto {
    @Getter
    public static class post {
        private String name;

    }


    @Getter
    public static class patch {
        private Long tagId;
        private String name;
        private Long boardId;
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long tagId;
        private String name;
        private Long boardId;

    }
}
