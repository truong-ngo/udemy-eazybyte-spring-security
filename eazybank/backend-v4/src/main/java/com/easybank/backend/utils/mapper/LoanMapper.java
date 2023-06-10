package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.Loan;
import com.easybank.backend.service.dto.LoanDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    @Mapping(target = "userId", source = "user.id")
    LoanDTO toDto(Loan loan);
    @InheritInverseConfiguration
    Loan toEntity(LoanDTO loanDTO);
}
