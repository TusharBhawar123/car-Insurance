package com.car_insurance.ExceptionHandler;

public class UserAlreadyDeleted extends RuntimeException{
    private String message;

    public UserAlreadyDeleted(){}

    public UserAlreadyDeleted(String msg) {
        super(msg);
        this.message = msg;
    }
}