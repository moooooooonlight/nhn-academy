package com.nhnacademy.exam.hotel.converter;

import java.time.LocalDateTime;

public interface TimeFormatter {

    String convert(LocalDateTime localDateTime);
}
