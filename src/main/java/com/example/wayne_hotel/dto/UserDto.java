package com.example.wayne_hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String password;
    private Integer age;
    private Integer unpaidRequest;
    private Integer canceledRequest;
    private Boolean isBlocked;
}
