package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.Account;
import com.easybank.backend.service.dto.AccountDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "userId", source = "user.id")
    AccountDTO toDto(Account account);
    @InheritInverseConfiguration
    Account toEntity(AccountDTO accountDTO);
}
