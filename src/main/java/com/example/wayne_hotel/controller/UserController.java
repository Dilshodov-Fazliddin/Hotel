package com.example.wayne_hotel.controller;

import com.example.wayne_hotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/panel")
public class UserController {
    private final UserService userService;

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping("/block/{id}")
    public ResponseEntity<String> blockUser(
            @PathVariable UUID id
    ){
        userService.blockUsersById(id);
        return ResponseEntity.status(200).body("User blocked");
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping("/Unblock/{id}")
    public ResponseEntity<String> UnblockUser(
            @PathVariable UUID id
    ){
        userService.unBlockUsersById(id);
        return ResponseEntity.status(200).body("User has unblocked");
    }

}
