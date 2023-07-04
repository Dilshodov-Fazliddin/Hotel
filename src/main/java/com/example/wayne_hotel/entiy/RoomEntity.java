package com.example.wayne_hotel.entiy;

import com.example.wayne_hotel.enums.HasMonitor;
import com.example.wayne_hotel.enums.RoomType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

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
    @ManyToOne
    private UserEntity owner;
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate beginDate;
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;
}
