package com.seb41_pre_014.board.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;



@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

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
