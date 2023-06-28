package com.example.wayne_hotel.service;

import com.example.wayne_hotel.dto.CardDto;
import com.example.wayne_hotel.entiy.CardEntity;
import com.example.wayne_hotel.entiy.UserEntity;
import com.example.wayne_hotel.exception.CaseEmptyException;
import com.example.wayne_hotel.exception.DataNotFoundException;
import com.example.wayne_hotel.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final ModelMapper modelMapper;

    public CardEntity save(CardDto cardDto,UUID owner_id){
        CardEntity card = modelMapper.map(cardDto, CardEntity.class);
        UserEntity user = new UserEntity();
        user.setId(owner_id);
        card.setOwner(user);
        return cardRepository.save(card);
    }

    public List<CardEntity>getUserCard(UUID ownerId){
       if (ownerId==null){
           throw new CaseEmptyException("Owner Id is empty");
       }
      return cardRepository.findByOwner_Id(ownerId);
    }

    @Transactional
    public void deleteById(UUID id){
        cardRepository.deleteById(id);
    }

    public CardEntity update(UUID id,CardDto cardDto){
        CardEntity card = cardRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException("Card not found"));
        modelMapper.map(cardDto,card);
        return cardRepository.save(card);
    }
}
