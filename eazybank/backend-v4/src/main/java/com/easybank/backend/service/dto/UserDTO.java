package com.easybank.backend.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private LocalDate createdDate;
    private List<String> roles;
}
