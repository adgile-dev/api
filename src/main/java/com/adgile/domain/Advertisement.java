package com.adgile.domain;

import com.adgile.domain.enums.AdvertisementTypeEnum;
import com.adgile.domain.enums.OsEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Advertisement extends BaseTimeEntity{

    @Id
    private Long id;

    private Long userId;

    private String name;

    private OsEnum os;

    private AdvertisementTypeEnum type;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String downloadUrl;

}
