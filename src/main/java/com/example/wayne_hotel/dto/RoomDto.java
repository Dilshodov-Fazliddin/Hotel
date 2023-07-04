package com.example.wayne_hotel.dto;

import com.example.wayne_hotel.enums.HasMonitor;
import com.example.wayne_hotel.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.access.annotation.Secured;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDto {
    private String number;
    private Integer size;
    private RoomType type;
    private HasMonitor hasMonitor;
    private Double price;
    private LocalDate beginDate;
    private LocalDate endDate;
}
