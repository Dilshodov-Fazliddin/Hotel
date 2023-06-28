package com.example.wayne_hotel.controller;

import com.example.wayne_hotel.dto.LoginDto;
import com.example.wayne_hotel.dto.UserDto;
import com.example.wayne_hotel.dto.response.JwtTokenResponse;
import com.example.wayne_hotel.entiy.UserEntity;
import com.example.wayne_hotel.enums.UserRole;
import com.example.wayne_hotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotel/auth")
public class AuthController {
    private final UserService userService;
    @PostMapping("/sign-up")
    public UserEntity saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto,List.of(UserRole.ROLE_USER));
    }

    @GetMapping("/login")
    public JwtTokenResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<JwtTokenResponse> refreshAccessToken(
            Principal principal
    ) {
        return ResponseEntity.ok(userService.createNewAccessToken(principal));
    }

}
