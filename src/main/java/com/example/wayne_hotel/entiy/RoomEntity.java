package com.example.wayne_hotel.entiy;

import com.example.wayne_hotel.enums.RoomType;
import jakarta.persistence.Entity;
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
    private RoomType type;
    private Boolean hasMonitor;
    private Double price;
}
