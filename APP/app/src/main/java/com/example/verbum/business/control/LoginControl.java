package com.example.verbum.business.control;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.Verify;

import java.io.IOException;
import java.util.ArrayList;

public class LoginControl {
    private EditText emailET;
    private EditText passwordET;
    private Context context;

    public LoginControl(Context context){
        this.context = context;
    }

    public EditText getEmailET() {
        return emailET;
    }

    public void setEmailET(EditText emailET) {
        this.emailET = emailET;
    }

    public EditText getPasswordET() {
        return passwordET;
    }

    public void setPasswordET(EditText passwordET) {
        this.passwordET = passwordET;
    }


    public User login() throws IOException, ClassNotFoundException {
        if(!emailET.getText().toString().isEmpty()){
            User u = Verify.hasItem(getUsers(),emailET.getText().toString());
            if(u!=null){
                if(u.getPassword().equals(passwordET.getText().toString())){
                    return u;
                }
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() throws IOException, ClassNotFoundException {
        UserPersistence userPersistence = new UserPersistence();
        return userPersistence.load(context);
    }


}