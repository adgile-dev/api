package com.adgile.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Media extends BaseTimeEntity {

    @Id
    private Long id;

    // 매체 id
    private Long userId;

    private Integer status;

    private String name;

    private String manager;

    private String email;


}
