package com.example.verbum.business.control.strategy;

import com.example.verbum.business.model.User;

import java.util.ArrayList;

public interface OrderByStrategy {
    public ArrayList<User> order(ArrayList<User> users);
}
