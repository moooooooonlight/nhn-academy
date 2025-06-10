package com.nhnacademy.exam.hotel.controller;

import com.nhnacademy.exam.hotel.client.AuthClient;
import com.nhnacademy.exam.hotel.dto.LoginRequest;
import com.nhnacademy.exam.hotel.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        return token;
    }
}
