package com.adgile.dto.conditional;

import com.adgile.domain.enums.CurrencyEnum;
import com.adgile.domain.enums.UserTypeEnum;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserConditional {

    private Long id;

    private boolean isDomestic;

    private UserTypeEnum type;

    private String userId;
    private String name;
    private String manager;
    private String email;
    private CurrencyEnum currencyType;
    private String invoiceEmail;

    @Builder
    public UserConditional(Long id, boolean isDomestic, UserTypeEnum type, String userId, String name, String manager, String email, CurrencyEnum currencyType, String invoiceEmail) {
        this.id = id;
        this.isDomestic = isDomestic;
        this.type = type;
        this.userId = userId;
        this.name = name;
        this.manager = manager;
        this.email = email;
        this.currencyType = currencyType;
        this.invoiceEmail = invoiceEmail;
    }
}
