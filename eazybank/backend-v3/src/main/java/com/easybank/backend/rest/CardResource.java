package com.easybank.backend.rest;

import com.easybank.backend.service.CardService;
import com.easybank.backend.service.dto.CardDTO;
import com.easybank.backend.utils.mapper.CardMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardResource {

    private final CardService cardService;
    private final CardMapper cardMapper;

    public CardResource(CardService cardService, CardMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardDTO>> getCards(@RequestParam Long id) {
        List<CardDTO> body = cardService.findAllByUser(id).stream().map(cardMapper::toDto).toList();
        return ResponseEntity.ok(body);
    }
}
