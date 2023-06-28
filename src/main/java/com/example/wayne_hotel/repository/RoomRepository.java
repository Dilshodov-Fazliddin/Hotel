package com.example.wayne_hotel.repository;

import com.example.wayne_hotel.entiy.RoomEntity;
import com.example.wayne_hotel.enums.RoomType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    Optional<RoomEntity> deleteRoomEntitiesById(UUID id);
    List<RoomEntity> findRoomEntitiesByType(Pageable pageable, RoomType type);
}
