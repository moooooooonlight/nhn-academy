package com.nhnacademy.exam.hotel.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PointType {
    REVIEW("리뷰"),
    RESERVATION("예약");

    private final String label;

    @JsonCreator
    public static PointType fromString(String str) {
        for(PointType type : PointType.values()) {
            if(type.name().equals(str)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknown PointType: " + str);
    }


    @JsonValue
    public String toJson() {
        return label;
    }
}
