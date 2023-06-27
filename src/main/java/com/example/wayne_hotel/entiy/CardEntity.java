package com.example.wayne_hotel.entiy;

import com.example.wayne_hotel.enums.CardType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CardEntity extends BaseEntity{
    private String number;
    private Double balance;
    private CardType type;
    @OneToMany
    private List<UserEntity> ownerId;
}
