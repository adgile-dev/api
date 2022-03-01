package com.adgile.dto.request;

import com.adgile.domain.enums.CurrencyEnum;
import com.adgile.domain.enums.UserTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserCreateRequest {
    private UserTypeEnum type;
    private boolean isDomestic;
    private String userId;
    private String name;
    private String manager;
    private String email;
    private CurrencyEnum currencyType;
    private String invoiceEmail;
}
