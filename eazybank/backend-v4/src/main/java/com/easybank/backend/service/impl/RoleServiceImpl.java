package com.easybank.backend.service.impl;

import com.easybank.backend.entity.Role;
import com.easybank.backend.repository.RoleRepository;
import com.easybank.backend.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findAllByName(name).stream().findFirst().orElse(null);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
