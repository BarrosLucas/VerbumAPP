package com.example.verbum.exception;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_DATA;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_SEX;

public class InvalidDataException extends Exception{
    public InvalidDataException(){
        super(INVALID_DATA);
    }

    public InvalidDataException(String message){
        super(message);
    }

    public InvalidDataException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidDataException(Throwable cause){
        super(cause);
    }
}
