package com.seb41_pre_014.tag.entity;

import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Builder
@Entity
public class SuggestedEditTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestedEditTagId; // PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tag; // Fk

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUGGESTED_EDIT_ID")
    private SuggestedEdit suggestedEdit; // FK
}
