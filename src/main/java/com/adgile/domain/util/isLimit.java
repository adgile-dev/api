package com.adgile.domain.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class isLimit {

    private boolean isLimitOfTotal;

    private boolean isLimitOfDaily;

    private boolean isLimitByTotalDailyCap;

    private boolean isLimitByDailyCap;

    public isLimit(boolean isLimitOfTotal, boolean isLimitOfDaily, boolean isLimitByTotalDailyCap, boolean isLimitByDailyCap) {
        this.isLimitOfTotal = isLimitOfTotal;
        this.isLimitOfDaily = isLimitOfDaily;
        this.isLimitByTotalDailyCap = isLimitByTotalDailyCap;
        this.isLimitByDailyCap = isLimitByDailyCap;
    }

    public static isLimit of (boolean isLimitOfTotal, boolean isLimitOfDaily, boolean isLimitByTotalDailyCap, boolean isLimitByDailyCap) {
        return new isLimit(isLimitOfTotal, isLimitOfDaily, isLimitByTotalDailyCap, isLimitByDailyCap);
    }
}
