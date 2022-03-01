package com.adgile.domain.enums;

import lombok.Getter;

@Getter
public enum
UserTypeEnum {
    MEDIA(0),
    ADVERTISEMENT(1);

    private final Integer type;

    UserTypeEnum(Integer type) {
        this.type = type;
    }
}
