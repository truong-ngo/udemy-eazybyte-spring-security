package com.easybank.backend.service.dto;

import com.easybank.backend.enumerate.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AccountDTO {
    private Long accountNumber;
    private Long userId;
    private AccountType accountType;
    private String branchAddress;
    private LocalDate createdDate;
}
