package com.example.verbum.business.control.memento;

import com.example.verbum.business.control.command.Switch;
import com.example.verbum.business.model.User;

import java.util.ArrayList;

public class UsersMemento {
    protected ArrayList<User> usersMemento;
    private static UsersMemento instanceSingleton;

    private UsersMemento(ArrayList<User> users){
        usersMemento = users;
    }

    public static UsersMemento getInstance(ArrayList<User> users){
        if(instanceSingleton == null){
            instanceSingleton = new UsersMemento(users);
        }
        return instanceSingleton;
    }

    public ArrayList<User> getUsersMemento(){
        return usersMemento;
    }
}
