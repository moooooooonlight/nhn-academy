package com.nhnacademy.exam.hotel.exception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException() {
        super("Hotel not found");
    }

    public HotelNotFoundException(long hotelId) {
        super(String.format("Hotel with id %d does not exist", hotelId));
    }
}
