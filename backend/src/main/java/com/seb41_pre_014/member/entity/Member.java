package com.seb41_pre_014.member.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import com.seb41_pre_014.tag.entity.BoardTag;
import com.seb41_pre_014.tag.entity.MemberTag;
import com.seb41_pre_014.tag.entity.Tag;
import com.seb41_pre_014.vote.entity.Vote;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 40, updatable = false, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    private String displayName;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    // Embedded 애너테이션으로 리팩토링 예정
    private String fullName;
    private String location;
    private String title;
    private String aboutMe;
    private String websiteLink;
    private String twitterLink;
    private String githubLink;
    private String profileImageUrl;
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;
    private int reputation = 0;
    private int questions = 0;
    private int answers = 0;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberTag> memberTags = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<SuggestedEdit> suggestedEdits = new ArrayList<>();

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addMemberTags(List<MemberTag> memberTags) {
        this.memberTags = memberTags;
    }

    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면계정"),
        MEMBER_DELETE("삭제대기");

        private String status;

        MemberStatus(String status) {
            this.status = status; }

    }

}
