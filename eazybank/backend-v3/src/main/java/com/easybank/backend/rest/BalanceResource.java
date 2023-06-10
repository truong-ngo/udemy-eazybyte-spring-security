package com.easybank.backend.rest;

import com.easybank.backend.service.AccountTransactionService;
import com.easybank.backend.service.dto.AccountTransactionDTO;
import com.easybank.backend.utils.mapper.AccountTransactionMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BalanceResource {

    private final AccountTransactionService accountTransactionService;
    private final AccountTransactionMapper accountTransactionMapper;

    public BalanceResource(AccountTransactionService accountTransactionService, AccountTransactionMapper accountTransactionMapper) {
        this.accountTransactionService = accountTransactionService;
        this.accountTransactionMapper = accountTransactionMapper;
    }

    @GetMapping("/balances")
    public ResponseEntity<List<AccountTransactionDTO>> getBalances(@RequestParam Long id) {
        List<AccountTransactionDTO> body = accountTransactionService
                .findAllByUserOrderByTransactionDateDesc(id)
                .stream().map(accountTransactionMapper::toDto).toList();
        return ResponseEntity.ok(body);
    }
}
