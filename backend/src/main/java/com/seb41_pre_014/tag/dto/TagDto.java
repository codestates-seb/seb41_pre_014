package com.seb41_pre_014.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class TagDto {
    @Getter
    public static class Post {
        @NotBlank(message = "Tag name is not valid")
        private String name;

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
