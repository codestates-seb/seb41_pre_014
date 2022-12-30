package com.seb41_pre_014.suggestedEdit.entity;


import com.seb41_pre_014.audit.BaseTimeEntity;
import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.tag.entity.SuggestedEditTag;
import com.seb41_pre_014.tag.entity.Tag;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuggestedEdit extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long editId;
    private String title;
    private String body;
    private EditStatus editStatus;

    @OneToMany(mappedBy = "suggestedEdit", cascade = CascadeType.ALL)
    private List<SuggestedEditTag> suggestedEditTags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    public void setId(Long editId) {
        this.editId = editId;
    }

    public void changeStatus(EditStatus editStatus) {
        this.editStatus = editStatus;
    }

    public void setMemberAndBoard(Member member, Board board) {
        this.member = member;
        this.board = board;
    }

    public enum EditStatus {
        EDIT_PENDING("Pending"),
        EDIT_ACCEPTED("Accepted"),
        EDIT_REJECTED("Rejected");

        private String status;

        EditStatus(String status) {
            this.status = status; }
    }

}
