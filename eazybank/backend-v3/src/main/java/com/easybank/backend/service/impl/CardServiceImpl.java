package com.easybank.backend.service.impl;

import com.easybank.backend.entity.Card;
import com.easybank.backend.entity.User;
import com.easybank.backend.repository.CardRepository;
import com.easybank.backend.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> findAllByUser(Long userId) {
        return cardRepository.findAllByUser(new User(userId));
    }
}
