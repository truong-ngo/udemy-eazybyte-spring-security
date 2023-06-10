package com.easybank.backend.service;

import com.easybank.backend.entity.Role;

public interface RoleService {
    Role findByName(String name);
    Role findById(Long id);
}
