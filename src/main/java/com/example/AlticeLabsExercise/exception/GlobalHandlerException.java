package com.example.AlticeLabsExercise.exception;


import com.example.AlticeLabsExercise.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidData.class)
    public ResponseEntity<ErrorResponseDto> invalidData(InvalidData invalidData, WebRequest webRequest){

        ErrorResponseDto responseErrorDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                invalidData.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseErrorDto,  HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponseDto> TypeMismatchException(MethodArgumentTypeMismatchException exception, WebRequest webRequest){

        ErrorResponseDto responseErrorDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseErrorDto,  HttpStatus.BAD_REQUEST);
    }

}

