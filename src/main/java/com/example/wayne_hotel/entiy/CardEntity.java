package com.example.wayne_hotel.entiy;

import com.example.wayne_hotel.enums.CardType;
import jakarta.persistence.*;
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
    @Column(nullable = false,unique = true)
    private String number;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardType type;

    @ManyToOne
    private UserEntity owner;

}
