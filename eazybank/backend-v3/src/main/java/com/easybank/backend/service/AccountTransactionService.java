package com.easybank.backend.service;

import com.easybank.backend.entity.AccountTransaction;

import java.util.List;

public interface AccountTransactionService {
    List<AccountTransaction> findAllByUserOrderByTransactionDateDesc(Long userId);
}
