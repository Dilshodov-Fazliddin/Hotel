package com.example.wayne_hotel.repository;

import com.example.wayne_hotel.entiy.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    Optional<RoomEntity> deleteRoomEntitiesById(UUID id);
}
