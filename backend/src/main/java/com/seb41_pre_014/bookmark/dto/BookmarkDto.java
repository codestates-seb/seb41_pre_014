package com.seb41_pre_014.bookmark.dto;


import lombok.*;


public class BookmarkDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long bookmarkId;
        private Long memberId;
        private Long boardId;
    }


}
