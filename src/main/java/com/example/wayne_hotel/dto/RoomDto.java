package com.example.wayne_hotel.dto;

import com.example.wayne_hotel.enums.HasMonitor;
import com.example.wayne_hotel.enums.RoomType;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "number Cannot be blank")
    private String number;

    @NotBlank(message = "size Cannot be blank")
    private Integer size;

    @NotBlank(message = "type Cannot be blank")
    private RoomType type;

    @NotBlank(message = "has monitor Cannot be blank")
    private HasMonitor hasMonitor;

    @NotBlank(message = "price Cannot be blank")
    private Double price;

    @NotBlank(message = "Begin date Cannot be blank")
    private LocalDate beginDate;

    @NotBlank(message = "End date Cannot be blank")
    private LocalDate endDate;
}
