package com.adgile.domain.enums;

import lombok.Getter;

// TODO: enum class 처리 어떻게 하면 좋을지 생각해보자
@Getter
public enum OsEnum {
    AOS(0),
    IOS(1);

    private final Integer type;

    OsEnum(Integer type) {
        this.type = type;
    }
}