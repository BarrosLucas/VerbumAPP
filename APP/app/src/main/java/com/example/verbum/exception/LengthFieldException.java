package com.example.verbum.exception;

import static com.example.verbum.infra.utils.ExceptionMessages.EMPTY_FIELD;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_LENGTH_FIELD;

public class LengthFieldException extends Exception{
    public LengthFieldException(){
        super(INVALID_LENGTH_FIELD);
    }

    public LengthFieldException(String message){
        super(message);
    }

    public LengthFieldException(String message, Throwable cause){
        super(message, cause);
    }

    public LengthFieldException(Throwable cause){
        super(cause);
    }
}
