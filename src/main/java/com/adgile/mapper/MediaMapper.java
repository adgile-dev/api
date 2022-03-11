package com.adgile.mapper;

import com.adgile.domain.Media;
import com.adgile.dto.response.MediaInfoResponse;
import com.querydsl.core.Tuple;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MediaMapper {

    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);

//    @Mapping(target = "userId", source = "userId")
//    @Mapping(target = "userId", expression = "java(user.get(\"userId\", String.class))")
//    @Mapping(source = "user.userId", target = "userId")

    MediaInfoResponse mediaToInfo(Tuple tuple);

}
