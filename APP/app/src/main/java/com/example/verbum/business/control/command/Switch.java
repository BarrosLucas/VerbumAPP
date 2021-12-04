package com.example.verbum.business.control.command;

import com.example.verbum.business.model.User;

import java.util.ArrayList;
import java.util.List;

public class Switch {
    private List<Command> history = new ArrayList<>();

    private static Switch instanceSingleton;

    private Switch(){

    }

    public static Switch getInstance(){
        if(instanceSingleton == null){
            instanceSingleton = new Switch();
        }
        return instanceSingleton;
    }

    public User storeAndExecute(Command cmd) throws Exception {
        this.history.add(cmd);
        return cmd.execute();
    }


}
