package com.seb41_pre_014.suggestedEdit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class SuggestedEditDto {


        @Getter
        public static class Post {
            @Size(min = 15, message = "Length of title must be more than 15") //15자
            private String title;

            @Size(min = 20, message = "Length of body must be more than 20")
            private String body; //20자

            @NotBlank(message = "Needs at least 1 tag")
            private List<String> tag;
        }


        @Getter
        public static class Patch {
            @NotBlank(message = "editId required")
            private Long editId;

            @Size(min = 20, message = "title length not valid")
            private String title;

            @NotBlank(message = "boardId required")
            private Long boardId;

            @NotBlank(message = "editorId required")
            private Long editorId;

            @Size(min = 20, message = "body length not valid")
            private String body;

            private String tag;
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
            private String body;
            private List<String> tag;
            private String editStatus;
        }
}
