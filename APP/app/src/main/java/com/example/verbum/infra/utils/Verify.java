package com.example.verbum.infra.utils;

import com.example.verbum.business.model.User;

import java.util.ArrayList;

public class Verify {

    public static User hasItem(ArrayList<User> users, String username){
        if(users != null){
            if(!users.isEmpty()){
                for(User user: users){
                    if(user.getUsername().equalsIgnoreCase(username)){
                        return user;
                    }
                }
            }
        }
        return null;
    }
}
