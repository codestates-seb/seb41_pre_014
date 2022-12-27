package com.seb41_pre_014.member.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import com.seb41_pre_014.vote.entity.Vote;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 20, updatable = false, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    private String displayName;

    // Embedded 애너테이션으로 리팩토링 예정
    private String fullName;
    private String location;
    private String title;
    private String aboutMe;
    private String websiteLink;
    private String twitterLink;
    private String githubLink;
    private String profileImageUrl;
    private MemberStatus memberStatus;
    private int reputation = 0;
    private int questions = 0;
    private int answers = 0;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();

    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면계정"),
        MEMBER_DELETE("삭제대기");

        private String status;

        MemberStatus(String status) {
            this.status = status; }

    }

}
