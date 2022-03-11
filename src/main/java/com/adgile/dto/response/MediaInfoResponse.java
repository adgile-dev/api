package com.adgile.dto.response;


import com.adgile.domain.enums.MediaStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaInfoResponse {

    private Long id;
    private String userId;

    private MediaStatusEnum status;

    private String name;
    private String manager;

    private String email;

    private String clickUrl;
    private String installPostback;
    private String eventPostback;

    // 구분
    private Boolean isDomestic;

    // 법인명
    private String userName;
    /// 매체코드
    private String userCode;

}
