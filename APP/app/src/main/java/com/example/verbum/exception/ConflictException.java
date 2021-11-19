package com.example.verbum.exception;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_SEX;
import static com.example.verbum.infra.utils.ExceptionMessages.USER_ALREADY_EXISTS;

public class ConflictException extends Exception{
    public ConflictException(){
        super(USER_ALREADY_EXISTS);
    }

    public ConflictException(String message){
        super(message);
    }

    public ConflictException(String message, Throwable cause){
        super(message, cause);
    }

    public ConflictException(Throwable cause){
        super(cause);
    }
}
