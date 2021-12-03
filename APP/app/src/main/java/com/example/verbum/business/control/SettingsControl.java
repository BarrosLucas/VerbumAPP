package com.example.verbum.business.control;

import android.content.Context;

import com.example.verbum.business.model.User;
import com.example.verbum.business.report.GeneratePDFReport;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.Dialog;

import java.io.IOException;
import java.util.ArrayList;

public class SettingsControl {
    private Context context;
    public SettingsControl(Context context){
        this.context = context;
    }

    public boolean delete(String username) throws IOException, ClassNotFoundException {
        ArrayList<User> users = null;
        users = getUsers();
        for(int i = 0; i<users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                users.remove(i);
                 if(updateList(users)){
                        return true;
                    }
            }
        }
        return false;
    }

    public ArrayList<User> getUsers() throws IOException, ClassNotFoundException {
        UserPersistence userPersistence = new UserPersistence();
        return userPersistence.load(context);
    }
    public boolean updateList(ArrayList<User> users) throws IOException {
        UserPersistence userPersistence = new UserPersistence();
        return userPersistence.save(users,context);
    }

    public void createPDF() throws IOException {
        (new GeneratePDFReport(context)).generateFile();
    }

    public void createIMG(){

    }
}
