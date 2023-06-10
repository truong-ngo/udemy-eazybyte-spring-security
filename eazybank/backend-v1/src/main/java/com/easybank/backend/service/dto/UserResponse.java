package com.easybank.backend.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserResponse {
    private String username;
    private List<String> authorities;
}
