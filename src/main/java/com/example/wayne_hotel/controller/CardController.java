package com.example.wayne_hotel.controller;

import com.example.wayne_hotel.dto.CardDto;
import com.example.wayne_hotel.entiy.CardEntity;
import com.example.wayne_hotel.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/card/panel")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;


    @PreAuthorize(value = "hasRole('USER')")
    @PostMapping("/save/{ownerId}")
    public ResponseEntity<String> saveCard(
            @Valid @RequestBody CardDto cardDto,
            @PathVariable UUID ownerId
    ){
        cardService.save(cardDto,ownerId);
        return ResponseEntity.status(200).body("Your card added");
    }

    @PreAuthorize(value = "hasRole('USER')")
    @GetMapping("/getCard")
    public ResponseEntity<List<CardEntity>>getAll(
        @RequestParam UUID ownerId
    ){
        return ResponseEntity.ok(cardService.getUserCard(ownerId));
    }

    @PreAuthorize(value = "hasRole('USER')")
    @PutMapping("/update/{ownerId}")
    public ResponseEntity<String>update(
            @PathVariable UUID ownerId,
            @Valid @RequestBody CardDto cardDto
    ){
        cardService.update(ownerId,cardDto);
        return ResponseEntity.status(200).body("card updated");
    }

    @PreAuthorize(value = "hasRole('USER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>delete(
        @PathVariable UUID id
    ){
        cardService.deleteById(id);
        return ResponseEntity.status(200).body("card deleted");
    }


    @PutMapping("/fillBalance/{cardId}")
    @PreAuthorize(value = "hasRole('USER')")
    public ResponseEntity<String>fillCardMoney(
            @PathVariable UUID cardId,
            @RequestParam Double money
    ){
        cardService.fillCardMoney(cardId,money);
        return ResponseEntity.status(200).body("Your balance has been topped up to this amount.("+money.toString()+")");
    }


}
