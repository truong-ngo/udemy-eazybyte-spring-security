package com.easybank.backend.rest;

import com.easybank.backend.service.AccountTransactionService;
import com.easybank.backend.service.UserService;
import com.easybank.backend.service.dto.AccountTransactionDTO;
import com.easybank.backend.service.dto.UserDTO;
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
    private final UserService userService;

    public BalanceResource(AccountTransactionService accountTransactionService, AccountTransactionMapper accountTransactionMapper, UserService userService) {
        this.accountTransactionService = accountTransactionService;
        this.accountTransactionMapper = accountTransactionMapper;
        this.userService = userService;
    }

    @GetMapping("/balances")
    public ResponseEntity<List<AccountTransactionDTO>> getBalances(@RequestParam String email) {
        UserDTO user = userService.findByEmail(email);
        List<AccountTransactionDTO> body = accountTransactionService
                .findAllByUserOrderByTransactionDateDesc(user.getId())
                .stream().map(accountTransactionMapper::toDto).toList();
        return ResponseEntity.ok(body);
    }
}
