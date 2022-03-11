package com.adgile.mapper;

import com.adgile.domain.User;
import com.adgile.dto.response.UserInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserInfoResponse userToInfo(User user);


    List<UserInfoResponse> usersToInfo(List<User> users);
}
