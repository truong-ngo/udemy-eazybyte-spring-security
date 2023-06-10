package com.easybank.backend.service.impl;

import com.easybank.backend.entity.Loan;
import com.easybank.backend.entity.User;
import com.easybank.backend.repository.LoanRepository;
import com.easybank.backend.service.LoanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> findAllByUserOrderByStartDateDesc(Long userId) {
        return loanRepository.findAllByUserOrderByStartDateDesc(new User(userId));
    }
}
