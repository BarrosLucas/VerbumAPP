package com.example.verbum.business.control.impl;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_PASS_COFIRM;

import com.example.verbum.business.control.Validator;
import com.example.verbum.exception.EmptyException;
import com.example.verbum.exception.InvalidDataException;

public class ValidatorConfirmPwd implements Validator {

    @Override
    public void isValid(String object) throws EmptyException {
        if(object.isEmpty()){
            throw new EmptyException();
        }
    }

    public void isEqualsPasswords(String pass, String confirmPass) throws InvalidDataException {
        if(pass.equals(confirmPass)){
            throw new InvalidDataException(INVALID_PASS_COFIRM);
        }
    }
}
