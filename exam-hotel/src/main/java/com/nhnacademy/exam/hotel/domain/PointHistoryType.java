package com.nhnacademy.exam.hotel.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PointHistoryType {
    EARN("적립"),
    USE("사용"),
    CANCEL("취소");

    private final String label;

    @JsonCreator
    public static PointHistoryType fromString(String str) {
        for(PointHistoryType type : PointHistoryType.values()) {
            if(type.name().equals(str)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknown PointHistoryType: " + str);
    }


    @JsonValue
    public String toJson() {
        return label;
    }
}
