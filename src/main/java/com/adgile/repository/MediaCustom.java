package com.adgile.repository;

import com.adgile.domain.Media;
import com.adgile.domain.conditional.MediaConditional;
import com.adgile.dto.response.MediaInfoResponse;
import com.querydsl.core.Tuple;

import java.util.Optional;

public interface MediaCustom {

    Optional<Media> findMedia(MediaConditional where);

    Optional<Tuple> findMediaOfUser(MediaConditional where);
}
