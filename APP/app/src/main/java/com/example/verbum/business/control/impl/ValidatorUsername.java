package com.example.verbum.business.control.impl;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_DATA_USER;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_LENGTH_USER;

import com.example.verbum.business.control.Validator;
import com.example.verbum.business.model.User;
import com.example.verbum.exception.ConflictException;
import com.example.verbum.exception.EmptyException;
import com.example.verbum.exception.InvalidDataException;
import com.example.verbum.exception.LengthFieldException;
import com.example.verbum.infra.utils.Verify;

import java.util.ArrayList;

public class ValidatorUsername implements Validator {
    @Override
    public void isValid(String object) throws EmptyException, LengthFieldException, InvalidDataException {
        if(object.isEmpty()){
            throw new EmptyException();
        }else if(object.length()<3 || object.length()>12){
            throw new LengthFieldException(INVALID_LENGTH_USER);
        }else if(object.matches(".*\\d.*")){
            throw new InvalidDataException(INVALID_DATA_USER);
        }
    }

    public void alreadyExists(String username, ArrayList<User> users) throws ConflictException {
        if(Verify.hasItem(users,username)!=null) {
            throw new ConflictException();
        }
    }
}
