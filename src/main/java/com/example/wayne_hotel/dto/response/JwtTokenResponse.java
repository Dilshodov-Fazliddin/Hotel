package com.example.wayne_hotel.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtTokenResponse {
    private String jwtToken;
    private String refreshToken;
}
