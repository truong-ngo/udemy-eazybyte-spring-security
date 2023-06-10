package com.easybank.backend.entity;

import com.easybank.backend.enumerate.LoanType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "loan_number")
    private Long loanNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name = "loan_type")
    @Enumerated(value = EnumType.STRING)
    private LoanType loanType;

    @Column(name = "total_loan")
    private Integer totalLoan;

    @Column(name = "amount_paid")
    private Integer amountPaid;

    @Column(name = "outstanding_amount")
    private Integer outstandingAmount;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
