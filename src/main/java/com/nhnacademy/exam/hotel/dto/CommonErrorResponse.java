package com.nhnacademy.exam.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommonErrorResponse {
    private String errorMessage;

    public static CommonErrorResponse from(HttpStatus httpStatus) {
        if(httpStatus.is4xxClientError()){
            return new CommonErrorResponse( "잘못된 요청입니다.");
        }else if(httpStatus.is5xxServerError()){
            return new CommonErrorResponse("시스템에서 에러가 발생했습니다.");
        }
        return new CommonErrorResponse("오류가 발생하였습니다.");
    }
}
