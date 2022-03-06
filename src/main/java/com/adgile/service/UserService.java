package com.adgile.service;

import com.adgile.domain.User;
import com.adgile.domain.conditional.UserConditional;
import com.adgile.dto.request.UserCreateRequest;
import com.adgile.dto.request.UserUpdateRequest;
import com.adgile.dto.response.UserInfoResponse;
import com.adgile.exceptions.BusinessException;
import com.adgile.exceptions.ErrorCode;
import com.adgile.mapper.UserMapper;
import com.adgile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfoResponse getUser(Long id) {
        UserConditional where = UserConditional.builder()
                .id(id)
                .build();

        User user = userRepository.getUser(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_EXIST));

        return UserMapper.INSTANCE.userToInfo(user);
    }

    public List<UserInfoResponse> getUsers() {
        UserConditional where = UserConditional.builder()
                .build();

        List<User> users = userRepository.getUsers(where);

        return UserMapper.INSTANCE.usersToInfo(users);
    }

    public Boolean isDuplicate(String userId) {

        UserConditional where = UserConditional.builder()
                .userId(userId)
                .build();

        userRepository.getUser(where)
                        .ifPresent(user -> {
                            throw new BusinessException(ErrorCode.USER_EXIST);
                        });

        return true;
    }

    @Transactional
    public void doRegister(UserCreateRequest request) {

        UserConditional where = UserConditional.builder()
                .userId(request.getUserId())
                .build();

        userRepository.getUser(where)
                        .ifPresent(user -> {
                            throw new BusinessException(ErrorCode.USER_EXIST);
                        });

        userRepository.save(request.toEntity());
    }

    @Transactional
    public void doModify(Long id, UserUpdateRequest request) {

        UserConditional where = UserConditional.builder()
                .id(id)
                .build();

        User user = userRepository.getUser(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_EXIST));

        user.update(request);
    }

    @Transactional
    public void doDelete(Long id) {
        UserConditional where = UserConditional.builder()
                .id(id)
                .build();

        User user = userRepository.getUser(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_EXIST));

        user.updateDelete();
    }

}
