package com.example.wayne_hotel.service;

import com.example.wayne_hotel.entiy.CardEntity;
import com.example.wayne_hotel.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

}
