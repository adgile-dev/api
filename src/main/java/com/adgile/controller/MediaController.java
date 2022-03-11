package com.adgile.controller;

import com.adgile.dto.request.MediaCreateRequest;
import com.adgile.dto.request.MediaUpdateRequest;
import com.adgile.service.MediaService;
import com.adgile.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/media")
public class MediaController {

    private final MediaService mediaService;

    @GetMapping("")
    public ApiResponse<String> getMedium() {
        return ApiResponse.OK;
    }


    @GetMapping("{id}")
    public ApiResponse<String> getMedia(@PathVariable Long id) {
        mediaService.getMedia(id);
        return ApiResponse.OK;
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
