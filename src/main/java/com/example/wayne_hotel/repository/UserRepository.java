package com.example.wayne_hotel.repository;

import com.example.wayne_hotel.entiy.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity>findUserEntitiesByUsername(String username);
}
