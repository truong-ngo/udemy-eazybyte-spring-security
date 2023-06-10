package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.AccountTransaction;
import com.easybank.backend.service.dto.AccountTransactionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountTransactionMapper {
    @Mapping(target = "userId", source = "user.id")
    AccountTransactionDTO toDto(AccountTransaction accountTransaction);
    @InheritInverseConfiguration
    AccountTransaction toEntity(AccountTransactionDTO accountTransactionDTO);
}
