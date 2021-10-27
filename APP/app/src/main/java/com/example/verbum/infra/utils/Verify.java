package com.example.verbum.infra.utils;

import com.example.verbum.business.model.User;

import java.util.ArrayList;

public class Verify {
    
    public static int howManyNumbers(String text){
        int ret = 0;
        for (char c:text.toCharArray()) {
            try{
                Integer.parseInt(""+c);
                ret ++;
            }catch (Exception e){

            }
        }
        return ret;
    }

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
