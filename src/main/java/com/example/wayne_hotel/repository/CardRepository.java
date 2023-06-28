package com.example.wayne_hotel.repository;

import com.example.wayne_hotel.entiy.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, UUID> {
}
