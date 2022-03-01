package com.adgile.domain.repository;

import com.adgile.domain.User;
import com.adgile.dto.conditional.UserConditional;

import java.util.Optional;

public interface UserRepositoryCustom {

    Optional<User> findUser(UserConditional where);
}
