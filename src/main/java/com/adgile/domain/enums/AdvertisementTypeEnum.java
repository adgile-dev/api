package com.adgile.domain.enums;

import lombok.Getter;

@Getter
public enum AdvertisementTypeEnum {
    CPI(0),
    CPS(1),
    CPA(2);

    private final Integer type;

    AdvertisementTypeEnum(Integer type) {
        this.type = type;
    }
}
