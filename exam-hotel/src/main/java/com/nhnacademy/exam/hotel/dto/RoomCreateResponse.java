package com.nhnacademy.exam.hotel.dto;

import com.nhnacademy.exam.hotel.domain.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RoomCreateResponse {
    private Long id;

    public static RoomCreateResponse from(Room room) {
        return new RoomCreateResponse(
                room.getRoomId()
        );
    }
}
