package com.car_insurance.ExceptionHandler;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class UserNotFound extends RuntimeException{
    private String message;

    public UserNotFound(){}

    public UserNotFound(String msg) {
        super(msg);
        this.message = msg;
    }
}
