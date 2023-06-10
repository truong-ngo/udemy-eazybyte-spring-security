package com.easybank.backend.entity;

import com.easybank.backend.enumerate.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_transaction")
public class AccountTransaction {
    @Id
    private String id;

    @Column(name="account_number")
    private Long accountNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="transaction_date")
    private LocalDate transactionDate;

    @Column(name = "transaction_summary")
    private String transactionSummary;

    @Column(name="transaction_type")
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "transaction_amount")
    private Integer transactionAmount;

    @Column(name = "closing_balance")
    private Integer closingBalance;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
