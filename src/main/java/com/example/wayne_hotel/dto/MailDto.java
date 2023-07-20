package com.example.wayne_hotel.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MailDto {
    private String email;
    private String message;
}
