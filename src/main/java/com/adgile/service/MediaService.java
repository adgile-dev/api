package com.adgile.service;

import com.adgile.domain.Media;
import com.adgile.domain.QMedia;
import com.adgile.domain.User;
import com.adgile.domain.conditional.MediaConditional;
import com.adgile.domain.conditional.UserConditional;
import com.adgile.dto.request.MediaCreateRequest;
import com.adgile.dto.request.MediaUpdateRequest;
import com.adgile.dto.response.MediaInfoResponse;
import com.adgile.exceptions.BusinessException;
import com.adgile.exceptions.ErrorCode;
import com.adgile.mapper.MediaMapper;
import com.adgile.repository.MediaRepository;
import com.adgile.repository.UserRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final UserRepository userRepository;
    private final MediaRepository mediaRepository;

//    public MediaInfoResponse getMedia(Long id) {
//
//        MediaConditional where = MediaConditional.builder()
//                .id(id)
//                .build();
//
//        Tuple tuple = mediaRepository.findMediaOfUser(where)
//                .orElseThrow(() -> new BusinessException(ErrorCode.MEDIA_NOT_EXIST));
//
//        System.out.println("----------- tuple:: ");
//        System.out.println(tuple);
//
//
//        return null;
//    }

    public MediaInfoResponse getMedia(Long id) {

        MediaConditional where = MediaConditional.builder()
                .id(id)
                .build();

        Tuple tuple = mediaRepository.findMediaOfUser(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEDIA_NOT_EXIST));

        return MediaMapper.INSTANCE.mediaToInfo(tuple);
    }


    public List<MediaInfoResponse> getMedium() {

        MediaConditional where = MediaConditional.
                builder()
                .build();

        List<Tuple> mediumOfUser = mediaRepository.findMediumOfUser(where);

        List<MediaInfoResponse> mediaInfoResponses = MediaMapper.INSTANCE.mediumToInfo(mediumOfUser);
        return mediaInfoResponses;
    }

    public void doRegister(MediaCreateRequest request) {

        // userId 기준으로 찾아보기
        UserConditional where = UserConditional.builder()
                .id(request.getUserId())
                .build();

        userRepository.getUser(where)
                        .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_EXIST));

        mediaRepository.save(request.toEntity());
    }

    @Transactional
    public void doModify(Long id, MediaUpdateRequest request) {

        UserConditional where = UserConditional.builder()
                .id(request.getUserId())
                .build();

        userRepository.getUser(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_EXIST));

        MediaConditional mediaWhere = MediaConditional.builder()
                .id(id)
                .build();

        Media media = mediaRepository.findMedia(mediaWhere)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEDIA_NOT_EXIST));

        media.update(request);
    }

    @Transactional
    public void doDelete(Long id) {
        MediaConditional where = MediaConditional.builder()
                .id(id)
                .build();

        Media media = mediaRepository.findMedia(where)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEDIA_NOT_EXIST));

        media.updateDelete();
    }
}
