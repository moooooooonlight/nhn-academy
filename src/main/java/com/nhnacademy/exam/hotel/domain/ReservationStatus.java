package com.nhnacademy.exam.hotel.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum ReservationStatus {
    RESERVED("예약완료"),
    CANCELLED("예약취소");

    private final String label;

    @JsonCreator
    public static ReservationStatus fromString(String str) {
        for(ReservationStatus status : ReservationStatus.values()) {
            if(status.name().equals(str)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown ReservationStatus: " + str);
    }

    @JsonValue
    public String toJson() {
        return label;
    }
}
