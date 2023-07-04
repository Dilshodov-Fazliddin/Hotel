package com.example.wayne_hotel.dto;

import com.example.wayne_hotel.entiy.UserEntity;
import com.example.wayne_hotel.enums.CardType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "number cannot be empty")
    private String number;
    @NotBlank(message = "type cannot be empty")
    private CardType type;
}
