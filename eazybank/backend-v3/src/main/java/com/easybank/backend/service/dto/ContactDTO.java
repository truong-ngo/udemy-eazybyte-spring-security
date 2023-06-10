package com.easybank.backend.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ContactDTO {
    private String id;
    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
    private LocalDate createdDate;
}
