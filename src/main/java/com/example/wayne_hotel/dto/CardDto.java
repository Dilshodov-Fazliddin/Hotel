package com.example.wayne_hotel.dto;

import com.example.wayne_hotel.entiy.UserEntity;
import com.example.wayne_hotel.enums.CardType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardDto {
    private String number;
    private Double balance;
    private CardType type;
    @OneToMany
    private List<UserEntity> ownerId;
}
