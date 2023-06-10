package com.easybank.backend.rest;

import com.easybank.backend.service.AccountService;
import com.easybank.backend.service.dto.AccountDTO;
import com.easybank.backend.utils.mapper.AccountMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountResource {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public AccountResource(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/accounts")
    public ResponseEntity<AccountDTO> getAccounts(@RequestParam Long id) {
        AccountDTO body = accountService.findAllByUserId(id).stream()
                .map(accountMapper::toDto).findFirst().orElseThrow(() -> new RuntimeException("Not found"));
        return ResponseEntity.ok(body);
    }
}
