package com.nhnacademy.exam.hotel.controller;

import com.nhnacademy.exam.hotel.dto.RoomCreateResponse;
import com.nhnacademy.exam.hotel.dto.RoomRequest;
import com.nhnacademy.exam.hotel.dto.RoomResponse;
import com.nhnacademy.exam.hotel.service.RoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/hotel-api/hotels")
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/{hotel-id}/rooms")
    public ResponseEntity<List<RoomResponse>> getRooms(@PathVariable("hotel-id") long hotelId) {
        return ResponseEntity.ok(roomService.getRoomsByHotelId(hotelId));
    }

    @PostMapping("/{hotel-id}/rooms")
    public ResponseEntity<RoomCreateResponse> createRoom(
            @PathVariable("hotel-id") long hotelId,
            @RequestBody RoomRequest roomRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roomService.createRoom(hotelId, roomRequest));
    }
}
