package com.example.verbum.exception;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_LENGTH_FIELD;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_SEX;

public class InvalidSexException extends Exception{
    public InvalidSexException(){
        super(INVALID_SEX);
    }

    public InvalidSexException(String message){
        super(message);
    }

    public InvalidSexException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidSexException(Throwable cause){
        super(cause);
    }
}
