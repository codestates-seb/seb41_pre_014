package com.seb41_pre_014.exception;

import lombok.Getter;

public enum ExceptionCode {
    BOARD_NOT_FOUND(404, "게시물을 찾을 수 없습니다."),
    VOTE_NOT_FOUND(404, "평가를 찾을 수 없습니다.");
    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
