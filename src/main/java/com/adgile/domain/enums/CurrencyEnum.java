package com.adgile.domain.enums;

import lombok.Getter;

@Getter
public enum CurrencyEnum {
    WON(0),
    DOLLAR(1);

    private final Integer value;

    CurrencyEnum(Integer value) {
        this.value = value;
    }
}
