package com.adgile.domain.enums;

import lombok.Getter;

@Getter
public enum MediaStatusEnum {
    UNAPPROVAL(0),
    APPROVAL(1);

    private final Integer status;

    MediaStatusEnum(Integer status) {
        this.status = status;
    }
}
