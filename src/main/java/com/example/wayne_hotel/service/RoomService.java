package com.example.wayne_hotel.service;

import com.example.wayne_hotel.dto.RoomDto;
import com.example.wayne_hotel.entiy.CardEntity;
import com.example.wayne_hotel.entiy.RoomEntity;
import com.example.wayne_hotel.entiy.UserEntity;
import com.example.wayne_hotel.enums.HasMonitor;
import com.example.wayne_hotel.enums.RoomType;
import com.example.wayne_hotel.exception.DataNotFoundException;
import com.example.wayne_hotel.exception.NotEnoughBalanceException;
import com.example.wayne_hotel.exception.RentedRoomException;
import com.example.wayne_hotel.repository.CardRepository;
import com.example.wayne_hotel.repository.RoomRepository;
import com.example.wayne_hotel.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final CardRepository cardRepository;


    public RoomEntity CreateRoom(RoomDto roomDto) {
        RoomEntity room = modelMapper.map(roomDto, RoomEntity.class);
        return roomRepository.save(room);
    }

    public List<RoomEntity> getAll(int size, int page, boolean AscPrice, RoomType type, HasMonitor hasMonitor) {
        Pageable pageable;

            if (AscPrice) {
                pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "price"));
            } else {
                pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "price"));
            }
        return roomRepository.findRoomEntitiesByTypeAndMonitor(pageable, type,hasMonitor);
    }

    public RoomEntity update(UUID id,RoomDto update){
        RoomEntity room =roomRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("room not found please retry"));
    modelMapper.map(update,room);

    return roomRepository.save(room);
    }

    @Transactional
    public void deleteById(UUID id){
        roomRepository.deleteRoomEntitiesById(id).orElseThrow(()->new DataNotFoundException("Room not found"));
    }

    public void deleteClient(UUID clientId,UUID roomId){
        UserEntity user = userRepository.findById(clientId)
                .orElseThrow(()-> new DataNotFoundException("User not found"));
        RoomEntity room=roomRepository.findById(roomId)
                .orElseThrow(()->new DataNotFoundException("Room not found"));

        user.setRentRoom(null);
        room.setOwner(null);

        userRepository.save(user);
        roomRepository.save(room);
    }
    public void rentRoom(UUID userId, UUID roomId, UUID cardId,LocalDate day,Integer daysForRent) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        RoomEntity room = roomRepository.findById(roomId)
                .orElseThrow(() -> new DataNotFoundException("Room not found"));
        CardEntity card = cardRepository.findById(cardId)
                .orElseThrow(() -> new DataNotFoundException("Card not found"));

        if (room.getBeginDate().equals(day) || room.getEndDate().equals(day)){
            throw new RentedRoomException("Sorry room is rented");
        } else if (day.isAfter(room.getBeginDate()) && day.isBefore(room.getEndDate())) {
            throw new RentedRoomException("Sorry room is rented");
        }
        if(card.getBalance()<room.getPrice()){
            user.setCanceledRequest(user.getCanceledRequest()+1);
            userRepository.save(user);
            throw new NotEnoughBalanceException("not enough money");
        }
        for (int i = 0; i < daysForRent; i++) {
            card.setBalance(card.getBalance()-room.getPrice());
        }

        LocalDate newDate=day.plusDays(daysForRent);
        room.setBeginDate(day);
        room.setOwner(user);
        room.setEndDate(newDate);
        user.setRentRoom(room.getNumber());
        cardRepository.save(card);
        userRepository.save(user);
    }
}
