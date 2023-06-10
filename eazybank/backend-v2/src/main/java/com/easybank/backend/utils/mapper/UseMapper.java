package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.Role;
import com.easybank.backend.entity.User;
import com.easybank.backend.service.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UseMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);

    default List<String> toListString(List<Role> roles) {
        return roles.stream().map(Role::getName).toList();
    }

    default List<Role> toListRole(List<String> strings) {
        return strings.stream().map(Role::new).toList();
    }
}
