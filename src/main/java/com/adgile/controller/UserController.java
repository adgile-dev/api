package com.adgile.controller;

import com.adgile.dto.request.UserCreateRequest;
import com.adgile.dto.request.UserUpdateRequest;
import com.adgile.dto.response.UserInfoResponse;
import com.adgile.service.UserService;
import com.adgile.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ApiResponse<List<UserInfoResponse>> getUsers() {
        return ApiResponse.success(userService.getUsers());
    }

    @GetMapping("{id}")
    public ApiResponse<UserInfoResponse> getUser(@PathVariable Long id) {
        return ApiResponse.success(userService.getUser(id));
    }

    @GetMapping("check/{userId}")
    public ApiResponse<Boolean> isDuplicated(@PathVariable String userId) {
        userService.isDuplicate(userId);

        return ApiResponse.success(true);
    }

    @PostMapping(value = "", produces = "application/json; charset=utf8")
    public ApiResponse<String> doRegister(@RequestBody UserCreateRequest request) {
        userService.doRegister(request);
        return ApiResponse.OK;
    }

    @PutMapping("{id}")
    public ApiResponse<String> doUpdate(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        userService.doModify(id, request);
        return ApiResponse.OK;
    }

    @DeleteMapping("{id}")
    public ApiResponse<String> doDelete(@PathVariable Long id) {
        userService.doDelete(id);
        return ApiResponse.OK;
    }
}
