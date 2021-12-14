package com.example.verbum.business.control.handle;

import android.content.Context;

import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Handle {
    public Handle nextHandle;
    public ArrayList<User> users;

    public abstract void handleCourier(String next, ArrayList<User> users, Context context) throws Exception;
}
