package com.nhnacademy.exam.hotel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.exam.hotel.domain.Room;
import com.nhnacademy.exam.hotel.domain.ViewType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RoomResponse {
    private Long id;
    private String name;
    private Integer capacity;
    private Integer floor;
    private Boolean bathtubFlag;
    private String viewType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    public static RoomResponse from(Room room) {
        return new RoomResponse(
                room.getRoomId(),
                room.getName(),
                room.getCapacity(),
                room.getFloor(),
                room.getBathtubFlag(),
                room.getViewType().getParameter(),
                room.getCreatedAt()
        );
    }
}
