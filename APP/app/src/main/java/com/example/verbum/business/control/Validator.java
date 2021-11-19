package com.example.verbum.business.control;

public interface Validator {
    void isValid(String object) throws Exception;

    static void validate(String value, Validator validator) throws Exception {
        validator.isValid(value);
    }
}
