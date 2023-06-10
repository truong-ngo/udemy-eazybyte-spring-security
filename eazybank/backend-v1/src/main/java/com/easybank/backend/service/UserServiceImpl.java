package com.easybank.backend.service;

import com.easybank.backend.entity.Role;
import com.easybank.backend.entity.User;
import com.easybank.backend.repository.UserRepository;
import com.easybank.backend.service.dto.UserResponse;
import com.easybank.backend.utils.mapper.UserDetailsMapper;
import com.easybank.backend.utils.mapper.UserResponseMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDetailsMapper userDetailsMapper;
    private final UserResponseMapper userResponseMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            RoleService roleService,
            UserDetailsMapper userDetailsMapper,
            UserResponseMapper userResponseMapper,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userDetailsMapper = userDetailsMapper;
        this.userResponseMapper = userResponseMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findAllByUsername(username)
                .stream().map(userDetailsMapper::toPrinciple).findFirst().orElse(null);
    }

    @Override
    public UserResponse register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        List<Role> roles = user.getRoles().stream().map(r -> roleService.findById(r.getId())).toList();
        user.setRoles(roles);
        return userResponseMapper.toResponse(user);
    }
}
