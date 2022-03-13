package com.adgile.controller;

import com.adgile.dto.request.MediaCreateRequest;
import com.adgile.dto.request.MediaUpdateRequest;
import com.adgile.dto.response.MediaInfoResponse;
import com.adgile.service.MediaService;
import com.adgile.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/media")
public class MediaController {

    private final MediaService mediaService;

    @GetMapping("")
    public ApiResponse<List<MediaInfoResponse>> getMedium() {

        return ApiResponse.success(mediaService.getMedium());
    }


    @GetMapping("{id}")
    public ApiResponse<MediaInfoResponse> getMedia(@PathVariable Long id) {
        return ApiResponse.success(mediaService.getMedia(id));
    }

    @PostMapping("")
    public ApiResponse<String> doRegister(@RequestBody MediaCreateRequest request) {
        mediaService.doRegister(request);
        return ApiResponse.OK;
    }

    @PutMapping("{id}")
    public ApiResponse<String> doModify(@PathVariable Long id, @RequestBody MediaUpdateRequest request) {
        mediaService.doModify(id, request);
        return ApiResponse.OK;
    }

    @DeleteMapping("{id}")
    public ApiResponse<String> doDelete(@PathVariable Long id) {
        mediaService.doDelete(id);
        return ApiResponse.OK;
    }
}
