package com.seb41_pre_014.suggestedEdit.entity;


import com.seb41_pre_014.audit.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuggestedEdit extends BaseTimeEntity {
    @Id
    private Long editId;
    private String title;
    private Long boardId; // FK
    private Long editorId; // FK editor member id
    private String body;
    private String tag;
    public enum editStatus {
        EDIT_PENDING("Pending"),
        EDIT_ACCEPTED("Accepted"),
        EDIT_REJECTED("Rejected");

        private String status;

        editStatus(String status) {
            this.status = status; }
    }

}
