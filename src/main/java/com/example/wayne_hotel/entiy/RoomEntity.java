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
    @Column(unique = true,nullable = false)
    private String number;

    @Column(unique = true,nullable = false)
    private Integer size;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HasMonitor monitor;

    @ManyToOne
    private UserEntity owner;

    @Column(nullable = false)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate beginDate;

    @Column(nullable = false)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;
}
