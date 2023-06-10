package com.easybank.backend.rest;

import com.easybank.backend.entity.User;
import com.easybank.backend.service.UserService;
import com.easybank.backend.service.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResource {

    private final UserService userService;

    public AuthResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody User user) {
        UserResponse body = userService.register(user);
        return ResponseEntity.ok(body);
    }
}
