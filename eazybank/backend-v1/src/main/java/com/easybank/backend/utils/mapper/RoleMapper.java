package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.Role;
import org.mapstruct.Mapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    default Role toRole(GrantedAuthority authority) {
        Role role = new Role();
        role.setName(authority.getAuthority());
        return role;
    }

    default GrantedAuthority toAuthority(Role role) {
        return new SimpleGrantedAuthority(role.getName());
    }

    default List<Role> toRoles(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream().map(this::toRole).collect(Collectors.toList());
    }

    default Collection<? extends GrantedAuthority> toAuthorities(List<Role> roles) {
        return roles.stream().map(this::toAuthority).collect(Collectors.toList());
    }
}
