package com.example.verbum.business.control.impl;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_DATA_PASSWORD;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_LENGTH_PASSWORD;

import com.example.verbum.business.control.Validator;
import com.example.verbum.exception.EmptyException;
import com.example.verbum.exception.InvalidDataException;
import com.example.verbum.exception.LengthFieldException;
import com.example.verbum.infra.utils.Verify;

public class ValidatorPassword implements Validator {
    @Override
    public void isValid(String object) throws EmptyException, LengthFieldException, InvalidDataException {
        if(object.isEmpty()){
            throw new EmptyException();
        }else if(object.length() < 8 || object.length()>20){
            throw new LengthFieldException(INVALID_LENGTH_PASSWORD);
        }else if(Verify.howManyNumbers(object) < 2 ||
                object.length() <= Verify.howManyNumbers(object)) {
            throw new InvalidDataException(INVALID_DATA_PASSWORD);
        }
    }
}
