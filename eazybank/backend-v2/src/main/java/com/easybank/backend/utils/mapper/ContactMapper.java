package com.easybank.backend.utils.mapper;

import com.easybank.backend.entity.Contact;
import com.easybank.backend.service.dto.ContactDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDTO toDto(Contact contact);
    Contact toEntity(ContactDTO contactDTO);
}
