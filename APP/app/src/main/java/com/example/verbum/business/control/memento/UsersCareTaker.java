package com.example.verbum.business.control.memento;

import java.util.ArrayList;

public class UsersCareTaker {
    private static UsersCareTaker instanceSingleton;

    private UsersCareTaker(){
        usersStates = new ArrayList<>();
    }

    public static UsersCareTaker getInstance(){
        if(instanceSingleton == null){
            instanceSingleton = new UsersCareTaker();
        }
        return instanceSingleton;
    }

    protected ArrayList<UsersMemento> usersStates;

    public void addMemento(UsersMemento usersMemento){
        usersStates.add(usersMemento);
    }

    public UsersMemento getLastState(){
        if(usersStates.size() <= 0){
            return UsersMemento.getInstance(new ArrayList<>());
        }
        UsersMemento stateSave = usersStates.get(usersStates.size()-1);
        usersStates.remove(usersStates.size()-1);
        return stateSave;
    }
}
