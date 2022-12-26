package com.seb41_pre_014.tag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberTag {
    @Id
    private Long memberTagId; // PK
    private Long tagId; // Fk
    private Long memberId; // FK
}
