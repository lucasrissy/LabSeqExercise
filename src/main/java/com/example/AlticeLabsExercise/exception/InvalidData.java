package com.example.AlticeLabsExercise.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidData extends RuntimeException{

    public InvalidData(String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s is not valid with the given input data %s : '%d'", resourceName, fieldName, fieldValue));
    }
}


