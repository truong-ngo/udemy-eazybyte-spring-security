package com.easybank.backend.entity;

import com.easybank.backend.enumerate.AccountType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    private Long accountNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "account_type")
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
