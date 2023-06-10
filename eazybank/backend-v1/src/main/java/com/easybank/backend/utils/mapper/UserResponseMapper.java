package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.Role;
import com.easybank.backend.entity.User;
import com.easybank.backend.service.dto.UserResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    @Mapping(source = "roles", target = "authorities")
    UserResponse toResponse(User user);
    @InheritInverseConfiguration
    User toEntity(UserResponse response);

    default List<String> toListString(List<Role> roles) {
        return roles.stream().map(Role::getName).toList();
    }

    default List<Role> toListRole(List<String> strings) {
        return strings.stream().map(Role::new).toList();
    }
}
