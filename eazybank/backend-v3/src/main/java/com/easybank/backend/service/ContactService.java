package com.easybank.backend.service;

import com.easybank.backend.entity.Contact;

import java.util.Random;

public interface ContactService {
    Contact save(Contact contact);
    String getServiceReqNumber();
}
