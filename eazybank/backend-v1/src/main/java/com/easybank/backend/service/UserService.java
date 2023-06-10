package com.easybank.backend.service;

import com.easybank.backend.entity.User;
import com.easybank.backend.service.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserResponse register(User user);
}
