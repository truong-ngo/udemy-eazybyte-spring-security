package com.easybank.backend.rest;

import com.easybank.backend.service.LoanService;
import com.easybank.backend.service.dto.LoanDTO;
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

    public LoanResource(LoanService loanService, LoanMapper loanMapper) {
        this.loanService = loanService;
        this.loanMapper = loanMapper;
    }

    @GetMapping("/loans")
    public ResponseEntity<List<LoanDTO>> getLoans(@RequestParam Long id) {
        List<LoanDTO> body = loanService.findAllByUserOrderByStartDateDesc(id).stream().map(loanMapper::toDto).toList();
        return ResponseEntity.ok(body);
    }
}
