package com.car_insurance.ExceptionHandler;


public class UserAlreadyExits extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String message;
    public UserAlreadyExits(String message) {
        super(message);
        this.message = message;
    }
}
