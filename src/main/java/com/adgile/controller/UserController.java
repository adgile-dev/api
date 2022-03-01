package com.adgile.controller;

import com.adgile.dto.request.UserCreateRequest;
import com.adgile.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/user")
public class UserController {

    private final UserService userService;

//    @PostMapping(name = "", produces = "application/json")
    @PostMapping(name = "")
    public void create(@RequestBody UserCreateRequest request) {

    }

    @GetMapping(value = "check/{userId}")
    public void duplicate(@PathVariable String userId) {
        userService.isDuplicated(userId);
    }
}
