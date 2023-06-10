package com.easybank.backend.service.impl;

import com.easybank.backend.entity.Role;
import com.easybank.backend.entity.User;
import com.easybank.backend.repository.UserRepository;
import com.easybank.backend.service.RoleService;
import com.easybank.backend.service.UserService;
import com.easybank.backend.service.dto.UserDTO;
import com.easybank.backend.utils.mapper.UserDetailsMapper;
import com.easybank.backend.utils.mapper.UseMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDetailsMapper userDetailsMapper;
    private final UseMapper userMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            RoleService roleService,
            UserDetailsMapper userDetailsMapper,
            UseMapper useMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userDetailsMapper = userDetailsMapper;
        this.userMapper = useMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findAllByEmail(username)
                .stream().map(userDetailsMapper::toPrinciple).findFirst().orElse(null);
    }

    @Override
    public UserDTO register(UserDTO user) {
        user.setPassword(user.getPassword());
        List<Role> roles = user.getRoles().stream().map(roleService::findByName).toList();
        User u = userMapper.toEntity(user);
        u.setRoles(roles);
        u.setCreatedDate(LocalDate.now());
        u = userRepository.save(u);
        return userMapper.toDto(u);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userRepository.findAllByEmail(email).stream().map(userMapper::toDto).findFirst().orElse(null);
    }
}
