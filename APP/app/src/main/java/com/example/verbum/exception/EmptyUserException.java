package com.example.verbum.exception;

import static com.example.verbum.infra.utils.ExceptionMessages.EMPTY_USER;

public class EmptyUserException extends Exception{
    public EmptyUserException(){
        super(EMPTY_USER);
    }

    public EmptyUserException(String message){
        super(message);
    }

    public EmptyUserException(String message, Throwable cause){
        super(message, cause);
    }

    public EmptyUserException(Throwable cause){
        super(cause);
    }
}
