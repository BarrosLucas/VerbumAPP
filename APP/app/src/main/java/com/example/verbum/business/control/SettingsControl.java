package com.example.verbum.business.control;

import android.content.Context;

import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;

import java.util.ArrayList;

public class SettingsControl {
    private Context context;
    public SettingsControl(Context context){
        this.context = context;
    }

    public boolean delete(String username){
        ArrayList<User> users = getUsers();
        for(int i = 0; i<users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                users.remove(i);
                return updateList(users);
            }
        }
        return false;
    }

    public ArrayList<User> getUsers(){
        UserPersistence userPersistence = new UserPersistence();
        return userPersistence.load(context);
    }
    public boolean updateList(ArrayList<User> users){
        UserPersistence userPersistence = new UserPersistence();
        return userPersistence.save(users,context);
    }
}
