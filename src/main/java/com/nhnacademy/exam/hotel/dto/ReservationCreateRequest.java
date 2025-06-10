package com.nhnacademy.exam.hotel.dto;

import com.nhnacademy.exam.hotel.domain.ReservationStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservationCreateRequest {
    private Long roomId;
    private Integer guestCount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus reservationStatus;
}
