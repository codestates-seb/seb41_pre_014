package com.seb41_pre_014.bookmark.entity;

import com.seb41_pre_014.audit.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bookmark extends BaseTimeEntity {

    @Id
    private long bookmarkId;
    private long memberId;
    private long boardId;

}