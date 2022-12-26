package com.seb41_pre_014.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberDto {

    @Getter
    public static class post {
        private String email;
        private String password;
        private String display_name;
    }


    @Getter
    public static class patch {
        private String display_name;
        private String full_name;
        private String location;
        private String title;
        private String website_link;
        private String twitter_link;
        private String github_link;
        private String profile_image_url;
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private long memberId;
        private String email;
        private String password;
        private String display_name;
        private String full_name;
        private String location;
        private String title;
        private String website_link;
        private String twitter_link;
        private String github_link;
        private String profile_image_url;
        private String memberstatus;
        private int reputation;
        private int questions;
        private int answers;
    }


}
