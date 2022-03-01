package com.adgile.service;

import com.adgile.domain.User;
import com.adgile.domain.repository.UserRepository;
import com.adgile.dto.conditional.UserConditional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean isDuplicated(String userId) {
        if (userId.isEmpty()) {
            return false;
        }

//        userRepository.findUser();
        UserConditional where = UserConditional.builder()
                .userId(userId)
                .build();

        Optional<User> user = userRepository.findUser(where);

        return true;
    }
}
