package com.nhnacademy.exam.hotel.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {

    ACTIVE("활성화"),
    INACTIVE("비활성"),
    WITHDRAWN("탈퇴");

    private final String label;

    @JsonCreator
    public static UserStatus fromString(String str) {
        for(UserStatus status : UserStatus.values()) {
            if(status.name().equals(str)) {
                return status;
            }
        }
        return ACTIVE;
    }

    @JsonValue
    public String toJson() {
        return label;
    }
}
