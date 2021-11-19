package com.example.verbum.business.control.impl;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_NAME_LENGTH;

import com.example.verbum.business.control.Validator;
import com.example.verbum.exception.EmptyException;
import com.example.verbum.exception.LengthFieldException;

public class ValidatorName implements Validator {
    @Override
    public void isValid(String object) throws EmptyException, LengthFieldException {
        if(object.isEmpty()){
            throw new EmptyException();
        }else if(object.length() < 5){
            throw new LengthFieldException(INVALID_NAME_LENGTH);
        }
    }
}
