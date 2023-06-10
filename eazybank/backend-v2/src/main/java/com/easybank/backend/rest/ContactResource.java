package com.easybank.backend.rest;

import com.easybank.backend.entity.Contact;
import com.easybank.backend.service.ContactService;
import com.easybank.backend.service.dto.ContactDTO;
import com.easybank.backend.utils.mapper.ContactMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class ContactResource {

    private final ContactService contactService;
    private final ContactMapper contactMapper;

    public ContactResource(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

    @PostMapping("/contacts")
    public ResponseEntity<ContactDTO> saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setId(contactService.getServiceReqNumber());
        contact.setCreatedDate(LocalDate.now());
        contact = contactService.save(contact);
        return ResponseEntity.ok(contactMapper.toDto(contact));
    }
}
