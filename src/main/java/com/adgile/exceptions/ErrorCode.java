package com.adgile.exceptions;

public enum ErrorCode {

    USER_EXIST(409, "존재하는 회원 아이디입니다");

    private final Integer status;
    private final String message;

    ErrorCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
