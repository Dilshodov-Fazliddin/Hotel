package com.example.wayne_hotel.controller;

import com.example.wayne_hotel.dto.RoomDto;
import com.example.wayne_hotel.entiy.RoomEntity;
import com.example.wayne_hotel.enums.HasMonitor;
import com.example.wayne_hotel.enums.RoomType;
import com.example.wayne_hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/room/panel")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    @PostMapping("/save")
    public ResponseEntity<RoomEntity> saveRoom(@RequestBody RoomDto roomDto){
        return ResponseEntity.ok(roomService.CreateRoom(roomDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoomEntity> updateRoom(@PathVariable UUID id, @RequestBody RoomDto roomDto){
        return ResponseEntity.ok(roomService.update(id,roomDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        roomService.deleteById(id);
        return ResponseEntity.status(200).body("deleted");
    }

    @GetMapping("/showRooms")
    public ResponseEntity<List<RoomEntity>>getAll(
            @RequestParam(required = false,defaultValue = "0")int page,
            @RequestParam(required = false,defaultValue = "3")int size,
            @RequestParam(required = false,defaultValue = "true")boolean AscPrice,
            @RequestParam(required = false,defaultValue = "ULTRA") HasMonitor hasMonitor,
            @RequestParam(required = false,defaultValue = "LUXURY") RoomType type
    ){
        return ResponseEntity.status(200).body(roomService.getAll(size,page,AscPrice,type,hasMonitor));
    }

    @PutMapping("/deleteClient")
    public ResponseEntity<String>deleteRoomOwner(
        @RequestParam UUID ownerId,
        @RequestParam UUID roomId
    ){
        roomService.deleteClient(ownerId,roomId);
        return ResponseEntity.status(200).body("Successfully deleted Client");
    }

    @PutMapping("/rent")
    public ResponseEntity<String>rentRoom(
            @RequestParam UUID userId,
            @RequestParam UUID roomId,
            @RequestParam UUID cardId,
            @RequestParam LocalDate date,
            @RequestParam Integer daysForRent
    ){
        roomService.rentRoom(userId,roomId,cardId,date,daysForRent);
        return ResponseEntity.status(200).body("Rent successfully");
    }
}
