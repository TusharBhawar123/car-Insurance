package com.car_insurance.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Object> UserNotFound(@org.jetbrains.annotations.NotNull Exception exception){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("UserNotFound",exception.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExits.class)
    public ResponseEntity<Object> UserAlreadyExist(Exception exception){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("UserAlreadyExist",exception.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAlreadyDeleted.class)
    public ResponseEntity<Object> UserAlreadyDeleted(UserAlreadyDeleted exception) {
        Map<String , String> errorMap=new HashMap<>();
        errorMap.put("User Already Deleted",exception.getMessage());
        return new ResponseEntity<>(errorMap,HttpStatus.MOVED_PERMANENTLY);
    }
}
