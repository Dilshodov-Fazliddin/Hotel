package com.example.wayne_hotel.controller;

import com.example.wayne_hotel.dto.LoginDto;
import com.example.wayne_hotel.dto.UserDto;
import com.example.wayne_hotel.dto.response.JwtTokenResponse;
import com.example.wayne_hotel.entiy.UserEntity;
import com.example.wayne_hotel.enums.UserRole;
import com.example.wayne_hotel.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotel/auth")
public class AuthController {
    private final UserService userService;
    @PostMapping("/sign-up")
    public ResponseEntity<UserEntity> saveUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){
        return ResponseEntity.ok(userService.saveUser(userDto,List.of(UserRole.ROLE_USER),bindingResult));
    }

    @GetMapping("/login")
    public ResponseEntity<JwtTokenResponse> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(userService.login(loginDto));
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<JwtTokenResponse> refreshAccessToken(
            Principal principal
    ) {
        return ResponseEntity.ok(userService.createNewAccessToken(principal));
    }

}
