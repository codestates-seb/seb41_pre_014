package com.seb41_pre_014.tag.entity;

import com.seb41_pre_014.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tag {
    @Id
    private Long tagId;
    private String name; // Tag 의 이름

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<BoardTag> boardTags = new ArrayList<>(); // FK

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<MemberTag> memberTag = new ArrayList<>();
}
