package com.easybank.backend.service.dto;

import com.easybank.backend.entity.User;
import com.easybank.backend.enumerate.LoanType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LoanDTO {
    private Long loanNumber;
    private Long userId;
    private LocalDate startDate;
    private LoanType loanType;
    private Integer totalLoan;
    private Integer amountPaid;
    private Integer outstandingAmount;
    private LocalDate createdDate;
}
