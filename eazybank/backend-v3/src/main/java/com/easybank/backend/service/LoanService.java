package com.easybank.backend.service;

import com.easybank.backend.entity.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> findAllByUserOrderByStartDateDesc(Long userId);
}
