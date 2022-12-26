package com.seb41_pre_014.member.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private MemberStatus memberstatus;
    private int reputation = 0;
    private int questions = 0;
    private int answers = 0;

    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면계정"),
        MEMBER_DELETE("삭제대기");

        private String status;

        MemberStatus(String status) {
            this.status = status; }

    }

}
