package com.nhnacademy.exam.hotel.client;

import com.nhnacademy.exam.hotel.dto.LoginRequest;
import com.nhnacademy.exam.hotel.dto.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authClient", url = "feign.url.auth")
public interface AuthClient {
    @PostMapping("/login")
    LoginResponse login(@RequestBody LoginRequest loginRequest);

}
