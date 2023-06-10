package com.easybank.backend.rest;

import com.easybank.backend.service.LoanService;
import com.easybank.backend.service.UserService;
import com.easybank.backend.service.dto.LoanDTO;
import com.easybank.backend.service.dto.UserDTO;
import com.easybank.backend.utils.mapper.LoanMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanResource {

    private final LoanService loanService;
    private final LoanMapper loanMapper;
    private final UserService userService;

    public LoanResource(LoanService loanService, LoanMapper loanMapper, UserService userService) {
        this.loanService = loanService;
        this.loanMapper = loanMapper;
        this.userService = userService;
    }

    @GetMapping("/loans")
    public ResponseEntity<List<LoanDTO>> getLoans(@RequestParam String email) {
        UserDTO user = userService.findByEmail(email);
        List<LoanDTO> body = loanService.findAllByUserOrderByStartDateDesc(user.getId()).stream().map(loanMapper::toDto).toList();
        return ResponseEntity.ok(body);
    }
}
