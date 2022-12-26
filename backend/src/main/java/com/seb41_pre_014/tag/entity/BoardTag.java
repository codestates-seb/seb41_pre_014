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
public class BoardTag {
    @Id
    private Long boardTagId; // PK
    private Long tagId; // Fk
    private Long boardId; // FK
}
