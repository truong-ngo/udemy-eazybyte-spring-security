package com.easybank.backend.rest;

import com.easybank.backend.service.AccountService;
import com.easybank.backend.service.UserService;
import com.easybank.backend.service.dto.AccountDTO;
import com.easybank.backend.service.dto.UserDTO;
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
    private final UserService userService;

    public AccountResource(AccountService accountService, AccountMapper accountMapper, UserService userService) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
        this.userService = userService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<AccountDTO> getAccounts(@RequestParam String email) {
        UserDTO user = userService.findByEmail(email);
        AccountDTO body = accountService.findAllByUserId(user.getId()).stream()
                .map(accountMapper::toDto).findFirst().orElseThrow(() -> new RuntimeException("Not found"));
        body.setMobileNumber(user.getMobileNumber());
        return ResponseEntity.ok(body);
    }
}
