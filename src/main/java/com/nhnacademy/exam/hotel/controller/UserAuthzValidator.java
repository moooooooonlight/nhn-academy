package com.nhnacademy.exam.hotel.controller;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserAuthzValidator {
    private static final Long VALID_USER_ID = 100L;

    // 원래는 여기서 accessToken값을 통해 블랙리스트 여부 확인 및 claims를 파서를 통해 전달하는 역할!
    public static Boolean isValid(Long userId) {
        if (Objects.isNull(userId))
            return false;

        return VALID_USER_ID.longValue() == userId.longValue();
    }
}
