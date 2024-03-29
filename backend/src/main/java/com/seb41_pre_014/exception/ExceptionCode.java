package com.seb41_pre_014.exception;

import lombok.Getter;

public enum ExceptionCode {
    BOARD_NOT_FOUND(404, "게시물을 찾을 수 없습니다."),
    MEMBER_EXIST(404, "이미 존재하는 회원입니다."),
    MEMBER_NOT_FOUND(404, "회원을 찾을 수 없습니다."),
    VOTE_NOT_FOUND(404, "평가를 찾을 수 없습니다."),
    BOOKMARK_NOT_FOUND(404, "북마크를 찾을 수 없습니다."),
    TAG_NOT_FOUND(404, "태그를 찾을 수 없습니다."),
    SUGGESTED_EDIT_NOT_FOUND(404, "수정 제안서를 찾을 수 없습니다.");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
