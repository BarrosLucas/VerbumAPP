package com.example.verbum.business.control;

import android.content.Context;

import com.example.verbum.business.control.handle.BaseHandle;
import com.example.verbum.business.control.handle.Handle;
import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.TAG;

import java.io.IOException;
import java.util.ArrayList;

public class SettingsControl {
    private Context context;
    private Handle handle;
    public SettingsControl(Context context){
        this.context = context;
        handle = new BaseHandle();
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

    public void generatePdf() throws Exception {
        handle.handleCourier(TAG.PDF_GENERATOR, getUsers(),context);
    }
    public void generateHtml() throws Exception {
        handle.handleCourier(TAG.HTML_GENERATOR, getUsers(),context);
    }

    public ArrayList<User> getUsers() throws IOException, ClassNotFoundException {
        UserPersistence userPersistence = UserPersistence.getInstance();
        return userPersistence.load(context);
    }
    public boolean updateList(ArrayList<User> users) throws IOException {
        UserPersistence userPersistence = UserPersistence.getInstance();
        return userPersistence.save(users,context);
    }
}
