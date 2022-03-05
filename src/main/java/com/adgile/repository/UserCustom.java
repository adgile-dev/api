package com.adgile.repository;

import com.adgile.domain.User;
import com.adgile.domain.conditional.UserConditional;

import java.util.List;
import java.util.Optional;

public interface UserCustom {

    Optional<User> getUser(UserConditional where);

    List<User> getUsers(UserConditional where);
}
