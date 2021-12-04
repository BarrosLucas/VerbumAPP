package com.example.verbum.infra.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.verbum.business.control.memento.UsersCareTaker;
import com.example.verbum.business.control.memento.UsersMemento;
import com.example.verbum.business.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserPersistence {
    private final String FILENAME = "persistence.dat";
    private static UserPersistence uniqueInstance;

    public UserPersistence(){

    }
    public static synchronized UserPersistence getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new UserPersistence();
        }
        return uniqueInstance;
    }

    public boolean save(ArrayList<User> users, Context context) throws IOException {
        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(new File(context.getFilesDir(), FILENAME)));
        for(User user: users){
            file.writeObject(user);
        }

        UsersMemento usersMemento = UsersMemento.getInstance(users);
        UsersCareTaker usersCareTaker = UsersCareTaker.getInstance();
        usersCareTaker.addMemento(usersMemento);

        file.close();
        return true;

    }

    public ArrayList<User> load(Context context) {
        ArrayList<User> users = new ArrayList<>();
        User user;
        ObjectInputStream file = null;
        try{
            file = new ObjectInputStream(new FileInputStream(new File(context.getFilesDir(),FILENAME)));
            do{
                user = (User) file.readObject();
                if(user != null){
                    users.add(user);
                }
            }while(user!=null);
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return users;
    }
}