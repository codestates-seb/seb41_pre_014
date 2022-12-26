package com.seb41_pre_014.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class MemberDto {

    @Getter
    public static class Post {
        @Email(message = "올바른 이메일이 아닙니다.")
        private String email;

        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
        message = "비밀번호는 최소 1개의 문자와 1개의 숫를 포함하여 최소 8자 이상어야 합니다.")
        private String password;

        private String displayName;
    }


    @Getter
    public static class Patch {
        private String displayName;
        private String fullName;
        private String location;
        private String title;
        private String websiteLink;
        private String twitterLink;
        private String githubLink;
        private String profileImageUrl;
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private long memberId;
        private String email;
        private String password;
        private String displayName;
        private String fullName;
        private String location;
        private String title;
        private String websiteLink;
        private String twitterLink;
        private String githubLink;
        private String profileImageUrl;
        private String memberstatus;
        private int reputation;
        private int questions;
        private int answers;
    }
}
