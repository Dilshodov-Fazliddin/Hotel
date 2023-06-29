package com.example.wayne_hotel.service;

import com.example.wayne_hotel.dto.RoomDto;
import com.example.wayne_hotel.entiy.RoomEntity;
import com.example.wayne_hotel.enums.HasMonitor;
import com.example.wayne_hotel.enums.RoomType;
import com.example.wayne_hotel.exception.DataNotFoundException;
import com.example.wayne_hotel.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;

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
}
