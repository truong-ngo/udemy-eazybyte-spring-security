
package com.easybank.backend.service.dto;

import com.easybank.backend.enumerate.TransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AccountTransactionDTO {
    private String id;
    private Long accountNumber;
    private Long userId;
    private LocalDate transactionDate;
    private String transactionSummary;
    private TransactionType transactionType;
    private Integer transactionAmount;
    private Integer closingBalance;
    private LocalDate createdDate;
}
