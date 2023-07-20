package com.example.wayne_hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    @NotBlank(message = "name Cannot be blank")
    private String name;

    @NotBlank(message = "email Cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?^_`{|}~-]+)*@"
            + "[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
    private String email;

    @NotBlank(message = "username Cannot be blank")
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Invalid password Example:#Password1")
    private String password;

    @NotNull(message = "age Cannot be empty")
    private Integer age;
}
