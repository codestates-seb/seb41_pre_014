package com.seb41_pre_014.suggestedEdit.dto;

import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import com.seb41_pre_014.tag.entity.SuggestedEditTag;
import com.seb41_pre_014.tag.entity.Tag;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class SuggestedEditDto {


        @Getter
        @AllArgsConstructor
        @Builder
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class Post {
            @Size(min = 15, message = "Length of title must be more than 15") //15자
            private String title;

            @Size(min = 20, message = "Length of body must be more than 20")
            private String body; //20자

            @NotNull(message = "Needs at least 1 tag")
            private List<String> tags;
        }


        @Getter
        @AllArgsConstructor
        @Builder
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class Patch {
            @NotNull(message = "editId required")
            private Long editId;

            @Size(min = 20, message = "title length not valid")
            private String title;

            @NotNull(message = "boardId required")
            private Long boardId;

            @NotNull(message = "editorId required")
            private Long editorId;

            @Size(min = 20, message = "body length not valid")
            private String body;

            private List<String> tags;
        }


        @Getter
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Response {
            private Long editId;
            private String title;
            private Long boardId;
            private Long editorId;
            private String editor;
            private String body;
            private List<String> tags;
            private String editStatus;

            public Response(SuggestedEdit edit) {
                this.editId = edit.getEditId();
                this.title = edit.getTitle();
                this.boardId = edit.getBoard().getBoardId();
                this.editorId = edit.getMember().getMemberId();
                this.editor = edit.getMember().getDisplayName();
                this.body = edit.getBody();
                this.tags = edit.getSuggestedEditTags() == null ? null : edit.getSuggestedEditTags().stream()
                        .map(suggestedEditTag -> suggestedEditTag.getTag().getName()).collect(Collectors.toList());
                this.editStatus = edit.getEditStatus().name();
            }
        }
}
