package com.easybank.backend.service.impl;

import com.easybank.backend.entity.Contact;
import com.easybank.backend.repository.ContactRepository;
import com.easybank.backend.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
