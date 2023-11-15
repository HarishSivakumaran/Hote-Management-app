package com.hotelmanagementwizard.hotelmanager.controlleradvice;

import com.hotelmanagementwizard.hotelmanager.dto.ErrorDto;
import com.hotelmanagementwizard.hotelmanager.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(ErrorDto.builder().message(e.getMessage()).build());
    }

}
