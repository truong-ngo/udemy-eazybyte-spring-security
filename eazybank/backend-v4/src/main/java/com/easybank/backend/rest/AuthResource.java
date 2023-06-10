package com.easybank.backend.rest;

import com.easybank.backend.service.UserService;
import com.easybank.backend.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO user) {
        UserDTO body = userService.register(user);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/users")
    public ResponseEntity<UserDTO> getUserDetailsAfterLogin(Authentication authentication) {
        UserDTO body = userService.findByEmail(authentication.getName());
        return ResponseEntity.ok(body);
    }
}
