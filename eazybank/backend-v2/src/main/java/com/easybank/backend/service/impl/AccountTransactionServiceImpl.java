package com.easybank.backend.service.impl;

import com.easybank.backend.entity.AccountTransaction;
import com.easybank.backend.entity.User;
import com.easybank.backend.repository.AccountTransactionRepository;
import com.easybank.backend.service.AccountTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    private final AccountTransactionRepository accountTransactionRepository;

    public AccountTransactionServiceImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public List<AccountTransaction> findAllByUserOrderByTransactionDateDesc(Long userId) {
        return accountTransactionRepository.findAllByUserOrderByTransactionDateDesc(new User(userId));
    }
}
