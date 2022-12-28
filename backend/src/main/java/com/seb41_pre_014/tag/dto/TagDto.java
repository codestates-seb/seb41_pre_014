package com.seb41_pre_014.tag.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

public class TagDto {
    @Getter
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Post {
        @NotNull(message = "Tag name is not valid")
        private String name;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long tagId;
        private String name;
    }
}
