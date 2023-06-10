package com.easybank.backend.service.dto;

import com.easybank.backend.enumerate.CardType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CardDTO {
    private Long id;
    private Long userId;
    private String cardNumber;
    private CardType cardType;
    private Integer totalLimit;
    private Integer amountUsed;
    private Integer availableAmount;
    private LocalDate createdDate;
}
