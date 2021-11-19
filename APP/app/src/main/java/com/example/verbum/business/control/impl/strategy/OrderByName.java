package com.example.verbum.business.control.impl.strategy;

import androidx.recyclerview.widget.SortedList;

import com.example.verbum.business.control.strategy.OrderByStrategy;
import com.example.verbum.business.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class OrderByName implements OrderByStrategy, Comparator<User> {
    @Override
    public ArrayList<User> order(ArrayList<User> users) {
        TreeSet<User> orderList = new TreeSet<>(this);
        for(User user: users){
            orderList.add(user);
        }
        ArrayList<User> list = new ArrayList<>();
        list.addAll(orderList);
        return  list;
    }

    @Override
    public int compare(User user, User t1) {
        return user.getUsername().compareTo(t1.getUsername());
    }
}
