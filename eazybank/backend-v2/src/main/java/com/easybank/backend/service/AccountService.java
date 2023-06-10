package com.easybank.backend.service;

import com.easybank.backend.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllByUserId(Long userId);
}
