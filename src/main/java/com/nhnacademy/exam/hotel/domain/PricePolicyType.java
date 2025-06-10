package com.nhnacademy.exam.hotel.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PricePolicyType {
    OFF_SEASON("비수기"),
    PEAK_SEASON("성수기");

    private final String label;

    @JsonCreator
    public static PricePolicyType fromString(String str) {
        for(PricePolicyType type : PricePolicyType.values()) {
            if(type.name().equals(str)) {
                return type;
            }
        }
        return OFF_SEASON;
    }


    @JsonValue
    public String toJson() {
        return label;
    }
}
