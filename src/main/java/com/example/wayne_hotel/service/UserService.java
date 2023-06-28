package com.example.wayne_hotel.service;

import com.example.wayne_hotel.dto.LoginDto;
import com.example.wayne_hotel.dto.UserDto;
import com.example.wayne_hotel.dto.response.JwtTokenResponse;
import com.example.wayne_hotel.entiy.UserEntity;
import com.example.wayne_hotel.enums.UserRole;
import com.example.wayne_hotel.exception.AuthenticationFailedException;
import com.example.wayne_hotel.exception.DataNotFoundException;
import com.example.wayne_hotel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    public UserEntity saveUser(UserDto userDto, List<UserRole>roles){
        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        user.setCanceledRequest(0);
        user.setUnpaidRequest(0);
        user.setIsBlocked(true);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public JwtTokenResponse login(LoginDto loginDto){
        UserEntity user =
                userRepository.findUserEntitiesByUsername(loginDto.getUsername())
                        .orElseThrow(()->new DataNotFoundException("Sorry,User not found"));
        if (user.getIsBlocked()){
            throw new AuthenticationFailedException("Your account has blocked");
        }
        if (passwordEncoder.matches(loginDto.getPassword(),user.getPassword())){
            return JwtTokenResponse.builder()
                    .jwtToken(jwtService.generateAccessToken(user))
                    .refreshToken(jwtService.generateRefreshToken(user))
                    .build();
        }
        throw new AuthenticationFailedException("Something went wrong,please check your password");
    }


    public JwtTokenResponse createNewAccessToken(Principal principal){
        UserEntity user=userRepository.findUserEntitiesByUsername(principal.getName())
                .orElseThrow(()->new DataNotFoundException("user not found"));
        String accessToken = jwtService.generateAccessToken(user);
        return JwtTokenResponse.builder().jwtToken(accessToken).build();
    }

    public void blockUsersById(UUID id){
        UserEntity user=userRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException("User not found"));
        user.setIsBlocked(true);
        userRepository.save(user);
    }

    public void unBlockUsersById(UUID id){
        UserEntity user=userRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException("User not found"));
        user.setIsBlocked(false);
        userRepository.save(user);
    }
}

