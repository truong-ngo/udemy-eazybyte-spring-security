package com.easybank.backend.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountResource {
    @GetMapping("/accounts")
    public String getAccounts() {
        return "Here is my accounts";
    }
}
