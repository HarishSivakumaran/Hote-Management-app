package com.hotelmanagementwizard.hotelmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ErrorDto {
    private String message;
    private HttpStatus httpStatus;
}
