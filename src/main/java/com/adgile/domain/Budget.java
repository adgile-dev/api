package com.adgile.domain;

import com.adgile.domain.util.isLimit;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Budget extends BaseTimeEntity {

    @Id
    private Long id;

    private Long advertisementId;

    // 총 예산
    private Integer total;

    // 일 예산
    private Integer daily;

    // 집행단가
    private Integer unitPrice;

    private Integer unitPriceByDollar;

    private Integer actualUnitPrice;

    private Integer actualUnitPriceByDollar;

    // 일 데일리 캡
    private Integer dailyCap;

    // 총 데일리캡
    private Integer totalDailyCap;

    @Embedded
    private com.adgile.domain.util.isLimit isLimit;
}
