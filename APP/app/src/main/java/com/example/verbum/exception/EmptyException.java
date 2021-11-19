package com.example.verbum.exception;

import static com.example.verbum.infra.utils.ExceptionMessages.EMPTY_FIELD;

public class EmptyException  extends Exception{
    public EmptyException(){
        super(EMPTY_FIELD);
    }

    public EmptyException(String message){
        super(message);
    }

    public EmptyException(String message, Throwable cause){
        super(message, cause);
    }

    public EmptyException(Throwable cause){
        super(cause);
    }

}
