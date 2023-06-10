package com.easybank.backend.service;

import com.easybank.backend.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> findAllByUser(Long userId);
}
