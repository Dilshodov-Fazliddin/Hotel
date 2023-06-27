package com.example.wayne_hotel.service;

import com.example.wayne_hotel.exception.DataNotFoundException;
import com.example.wayne_hotel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserEntitiesByUsername(username)
                .orElseThrow(()->new DataNotFoundException("User Not found"));
    }
}
