package com.example.verbum.business.control;

import com.example.verbum.business.model.User;
import com.example.verbum.exception.EmptyUserException;

import java.io.IOException;

public class UserFacade {
    LoginControl loginControl;
    RegisterControl registerControl;
    public UserFacade(LoginControl loginControl, RegisterControl registerControl){
        this.loginControl = loginControl;
        this.registerControl = registerControl;
    }

    public User doLogin(String email, String pass) throws IOException, ClassNotFoundException, EmptyUserException {
        return loginControl.login(email,pass);
    }

    public User doRegister(String nameET,
                           String emailET,
                           String passwordET,
                           String confirmPassET,
                           String birthDateET,
                           String sexET) throws Exception {
        return registerControl.createNewUser(
                nameET,
                emailET,
                passwordET,
                confirmPassET,
                birthDateET,
                sexET
        );
    }

    public void undoRegisters(){

    }
}
