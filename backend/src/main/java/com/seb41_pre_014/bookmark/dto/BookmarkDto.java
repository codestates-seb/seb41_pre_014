package com.seb41_pre_014.bookmark.dto;


import com.seb41_pre_014.bookmark.entity.Bookmark;
import lombok.*;


public class BookmarkDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long bookmarkId;
        private Long memberId;
        private Long boardId;

        @Builder
        public Response(Bookmark bookmark) {
            this.bookmarkId = bookmark.getBookmarkId();
            this.memberId = bookmark.getMember().getMemberId();
            this.boardId = bookmark.getBoard().getBoardId();
        }
    }


}
