package com.easybank.backend.service.impl;

import com.easybank.backend.entity.Account;
import com.easybank.backend.entity.User;
import com.easybank.backend.repository.AccountRepository;
import com.easybank.backend.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAllByUserId(Long userId) {
        return accountRepository.findAllByUser(new User(userId));
    }
}
