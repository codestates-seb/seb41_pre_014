package com.seb41_pre_014.bookmark.dto;


import lombok.*;


public class BookmarkDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private long bookmarkId;
        private long memberId;
        private long boardId;
    }


}
