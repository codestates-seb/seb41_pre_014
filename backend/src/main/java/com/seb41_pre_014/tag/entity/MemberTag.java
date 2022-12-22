package com.seb41_pre_014.tag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberTag {
    private Long memberTagId; // PK
    private Long tagId; // Fk
    private Long memberId; // FK
}
