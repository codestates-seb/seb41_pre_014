package com.seb41_pre_014.tag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tag {
    @Id
    private Long tagId;
    private String name; // Tag 의 이름
    private Long boardId; // FK
}
