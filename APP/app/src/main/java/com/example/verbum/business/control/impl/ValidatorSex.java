package com.example.verbum.business.control.impl;

import com.example.verbum.business.control.Validator;
import com.example.verbum.exception.EmptyException;
import com.example.verbum.exception.InvalidSexException;

public class ValidatorSex implements Validator {
    @Override
    public void isValid(String object) throws InvalidSexException, EmptyException {
        if(!object.equalsIgnoreCase("masculino") &&
                !object.equalsIgnoreCase("feminino")) {
            throw new InvalidSexException();
        }else if(object.isEmpty()){
            throw new EmptyException();
        }
    }
}
