package com.example.verbum.business.control;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import com.example.verbum.business.model.User;
import com.example.verbum.exception.EmptyException;
import com.example.verbum.exception.EmptyUserException;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.Verify;

import java.io.IOException;
import java.util.ArrayList;

public class LoginControl {
    private Context context;

    public LoginControl(Context context){
        this.context = context;
    }


    public User login(String emailET, String passwordET) throws IOException, ClassNotFoundException, EmptyUserException {
        if(!emailET.isEmpty()){
            User u = Verify.hasItem(getUsers(),emailET);
            if(u!=null){
                if(u.getPassword().equals(passwordET)){
                    updateRegistLogin(u.getUsername());
                    return u;
                }
            }
        }
        throw new EmptyUserException();
    }

    public ArrayList<User> getUsers() throws IOException, ClassNotFoundException {
        UserPersistence userPersistence = new UserPersistence();
        return userPersistence.load(context);
    }

    public void updateRegistLogin(String user) throws IOException, ClassNotFoundException {
        ArrayList<User> users = getUsers();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(user)){
                users.get(i).setAmountAccess(users.get(i).getAmountAccess()+1);
                UserPersistence userPersistence = new UserPersistence();
                userPersistence.save(users,context);
            }
        }
    }


}