package com.nhnacademy.exam.hotel.service;

import com.nhnacademy.exam.hotel.client.AuthClient;
import com.nhnacademy.exam.hotel.dto.LoginRequest;
import com.nhnacademy.exam.hotel.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthClient authClient;

    public String login(LoginRequest loginRequest) {
        LoginResponse login = authClient.login(loginRequest);

        return login.accessToken();
    }
}
