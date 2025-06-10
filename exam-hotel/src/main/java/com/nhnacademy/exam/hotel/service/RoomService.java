package com.nhnacademy.exam.hotel.service;

import com.nhnacademy.exam.hotel.domain.Hotel;
import com.nhnacademy.exam.hotel.domain.Room;
import com.nhnacademy.exam.hotel.domain.ViewType;
import com.nhnacademy.exam.hotel.dto.RoomCreateResponse;
import com.nhnacademy.exam.hotel.dto.RoomRequest;
import com.nhnacademy.exam.hotel.dto.RoomResponse;
import com.nhnacademy.exam.hotel.exception.HotelNotFoundException;
import com.nhnacademy.exam.hotel.repository.HotelRepository;
import com.nhnacademy.exam.hotel.repository.RoomRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// RoomResponse 클래스는 Room Entity 객체를 클라이언트에게 응답하기 위한 DTO 입니다.
// 객실 정보 조회 API 명세서의 Response 양식을 보시고 적절한 형태로 RoomResponse 클래스를 만들어주세요.
// JSON message 의 viewType 속성은 미리 제공한 ViewType enum의 parameter 값을 사용해야 합니다.
// Hint. javax.persistence.AttributeConverter 인터페이스와 @Convert 애너테이션을 사용하면 됩니다.

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public List<RoomResponse> getRoomsByHotelId(long hotelId){
        hotelRepository.findById(hotelId).orElseThrow(()->new HotelNotFoundException(hotelId));
        List<Room> roomList = roomRepository.findByHotel_HotelId(hotelId);
        return roomList.stream().map(RoomResponse::from).toList();
    }

    public RoomCreateResponse createRoom(long hotelId,RoomRequest roomRequest){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()->new HotelNotFoundException(hotelId));
        ViewType viewType = ViewType.fromParameter(roomRequest.viewType());

        Room room = Room.builder()
                .hotel(hotel)
                .name(roomRequest.name())
                .capacity(roomRequest.capacity())
                .floor(roomRequest.floor())
                .bathtubFlag(roomRequest.hasBathtub())
                .viewType(viewType)
                .createdAt(LocalDateTime.now())
                .build();
        return RoomCreateResponse.from(roomRepository.save(room));
    }
}
