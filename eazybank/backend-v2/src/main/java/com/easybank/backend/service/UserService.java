package com.easybank.backend.service;

import com.easybank.backend.entity.User;
import com.easybank.backend.service.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO register(UserDTO userDTO);
    UserDTO findByEmail(String email);
}
