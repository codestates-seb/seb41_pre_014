package com.seb41_pre_014.member.dto;

import com.seb41_pre_014.member.entity.Member;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Post {
        @NotBlank(message = "이메일 주소를 입력해주세요.")
        @Email(message = "올바른 이메일 주소가 아닙니다.")
        private String email;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$",
        message = "비밀번호는 최소 1개의 문자와 1개의 숫를 포함하여 최소 8자 이상어야 합니다.")
        private String password;

        private String displayName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Patch {

        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$",
        message = "비밀번호는 최소 1개의 문자와 1개의 숫를 포함하여 최소 8자 이상어야 합니다.")
        private String password;
        private String displayName;
        private String fullName;
        private String location;
        private String title;
        private String aboutMe;
        private String websiteLink;
        private String twitterLink;
        private String githubLink;
        private String profileImageUrl;
        private List<String> tags;
    }


    @Getter
//    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private long memberId;
        private String email;
        private String password;
        private String displayName;
        private String fullName;
        private String location;
        private String title;
        private String aboutMe;
        private String websiteLink;
        private String twitterLink;
        private String githubLink;
        private String profileImageUrl;
        private List<String> tags;
        private String memberStatus;
        private int reputation;
        private int questions;
        private int answers;

        @Builder
        public Response(Member member) {
            this.memberId = member.getMemberId();
            this.email = member.getEmail();
            this.password = member.getPassword();
            this.displayName = member.getDisplayName();
            this.fullName = member.getFullName();
            this.location = member.getLocation();
            this.title = member.getTitle();
            this.aboutMe = member.getAboutMe();
            this.websiteLink = member.getWebsiteLink();
            this.twitterLink = member.getTwitterLink();
            this.githubLink = member.getGithubLink();
            this.profileImageUrl = member.getProfileImageUrl();
            this.tags = member.getMemberTags() == null ? null : member.getMemberTags().stream()
                    .map(memberTag -> memberTag.getTag().getName()).collect(Collectors.toList());
            this.memberStatus = member.getMemberStatus().name();
            this.reputation = member.getReputation();
            this.questions = member.getQuestions();
            this.answers = member.getAnswers();
        }
    }
}
