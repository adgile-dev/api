package com.adgile.exceptions;

public enum ErrorCode {

    USER_NOT_EXIST(403, "존재하지 않는 회원 입니다."),
    USER_EXIST(403, "존재하는 회원 입니다.");

     private Integer code;
     private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
