package com.seb41_pre_014.suggestedEdit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SuggestedEditDto {


        @Getter
        public static class post {
            private String title;
            private String body;
            private String display_name;
        }


        @Getter
        public static class patch {
            private Long editId;
            private String title;
            private Long boardId;
            private Long editorId;
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
            private String tag;
        }
}
