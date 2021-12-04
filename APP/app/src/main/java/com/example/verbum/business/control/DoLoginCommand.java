package com.example.verbum.business.control;

import com.example.verbum.business.control.UserFacade;
import com.example.verbum.business.control.command.Command;
import com.example.verbum.business.model.User;
import com.example.verbum.exception.EmptyUserException;

import java.io.IOException;

public class DoLoginCommand implements Command {
    private UserFacade facade;
    private String email;
    private String password;

    public DoLoginCommand(UserFacade facade, String email, String password){
        this.facade = facade;
        this.email = email;
        this.password = password;
    }

    @Override
    public User execute() throws EmptyUserException, IOException, ClassNotFoundException {
        return facade.doLogin(email,password);
    }
}
