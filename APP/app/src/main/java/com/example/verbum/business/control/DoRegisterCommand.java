package com.example.verbum.business.control;

import com.example.verbum.business.control.command.Command;
import com.example.verbum.business.model.User;
import com.example.verbum.exception.EmptyUserException;

import java.io.IOException;

public class DoRegisterCommand implements Command {
    private UserFacade facade;
    private String nameET;
    private String emailET;
    private String passwordET;
    private String confirmPassET;
    private String birthDateET;
    private String sexET;

    public DoRegisterCommand(UserFacade facade,
                             String nameET,
                             String emailET,
                             String passwordET,
                             String confirmPassET,
                             String birthDateET,
                             String sexET){
        this.facade = facade;
        this.nameET = nameET;
        this.emailET = emailET;
        this.passwordET = passwordET;
        this.confirmPassET = confirmPassET;
        this.birthDateET = birthDateET;
        this.sexET = sexET;
    }

    @Override
    public User execute() throws Exception {
        return facade.doRegister(
                nameET,
                emailET,
                passwordET,
                confirmPassET,
                birthDateET,
                sexET
        );
    }
}
