package com.adgile.domain.enums;

import lombok.Getter;

@Getter
public enum CurrencyTypeEnum {
    NET(0),
    GROSS(1);

    private final Integer value;

    CurrencyTypeEnum(Integer value) {
        this.value = value;
    }
}
