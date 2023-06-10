package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.User;
import com.easybank.backend.security.UserPrinciple;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserDetailsMapper {
    User toEntity(UserPrinciple principle);
    UserPrinciple toPrinciple(User user);
}
