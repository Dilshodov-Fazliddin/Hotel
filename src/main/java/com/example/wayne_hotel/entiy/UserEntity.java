package com.example.wayne_hotel.entiy;

import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity extends BaseEntity{
    private String name;
    private String email;
    private String password;
    private Integer age;
    private Integer unpaidRequest;
    private Integer canceledRequest;
    private Boolean isBlocked;
}
