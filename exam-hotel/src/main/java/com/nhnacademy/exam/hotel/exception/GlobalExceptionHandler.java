package com.nhnacademy.exam.hotel.exception;

import com.nhnacademy.exam.hotel.dto.CommonErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<CommonErrorResponse> handleHotelNotFoundException(HotelNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(CommonErrorResponse.from(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(UserAccessDeniedException.class)
    public ResponseEntity<CommonErrorResponse> handleUserAccessDeniedException(UserAccessDeniedException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(CommonErrorResponse.from(HttpStatus.FORBIDDEN));
    }
}
