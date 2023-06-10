package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.Card;
import com.easybank.backend.service.dto.CardDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardMapper {
    @Mapping(target = "userId", source = "user.id")
    CardDTO toDto(Card card);
    @InheritInverseConfiguration
    Card toEntity(CardDTO cardDTO);
}
