package com.example.wayne_hotel.entiy;

import com.example.wayne_hotel.enums.HasMonitor;
import com.example.wayne_hotel.enums.RoomType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RoomEntity extends BaseEntity {
    private String number;
    private Integer size;
    @Enumerated(EnumType.STRING)
    private RoomType type;
    private Double price;
    @Enumerated(EnumType.STRING)
    private HasMonitor monitor;
}
