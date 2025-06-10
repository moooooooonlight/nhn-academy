package com.nhnacademy.exam.hotel.dto;

public record RoomRequest(
        String name,
        Integer capacity,
        Integer floor,
        Boolean hasBathtub,
        String viewType
) {
}
