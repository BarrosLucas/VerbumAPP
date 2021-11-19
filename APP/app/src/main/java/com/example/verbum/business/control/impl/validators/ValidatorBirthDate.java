package com.example.verbum.business.control.impl.validators;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_BIRTH_DATE;

import com.example.verbum.business.control.Validator;
import com.example.verbum.exception.EmptyException;
import com.example.verbum.exception.InvalidDataException;

public class ValidatorBirthDate implements Validator {

    @Override
    public void isValid(String object) throws EmptyException, InvalidDataException {
        if(object.isEmpty()){
            throw new EmptyException();
        }else if(object.length()!=10){
            throw new InvalidDataException(INVALID_BIRTH_DATE);
        }
    }
}
