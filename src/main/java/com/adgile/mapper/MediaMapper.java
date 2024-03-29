package com.adgile.mapper;

import com.adgile.dto.response.MediaInfoResponse;
import com.querydsl.core.Tuple;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface MediaMapper {

    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);

    @Mapping(target="id", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getId())")
    @Mapping(target="userId", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getUserId())")
    @Mapping(target="name", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getName())")
    @Mapping(target="status", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getStatus())")
    @Mapping(target="code", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getCode())")
    @Mapping(target="manager", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getManager())")
    @Mapping(target="email", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getEmail())")
    @Mapping(target="clickUrl", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getClickUrl())")
    @Mapping(target="installPostback", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getInstallPostback())")
    @Mapping(target="eventPostback", expression = "java(tuple.get(0, com.adgile.domain.Media.class).getEventPostback())")
    @Mapping(target="isDomestic", expression = "java(tuple.get(1, com.adgile.domain.User.class).getIsDomestic())")
    @Mapping(target="userName", expression = "java(tuple.get(1, com.adgile.domain.User.class).getName())")
    MediaInfoResponse mediaToInfo(Tuple tuple);

    List<MediaInfoResponse> mediumToInfo(List<Tuple> tuple);

}
