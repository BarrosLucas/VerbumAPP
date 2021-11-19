package com.example.verbum.business.control.impl.strategy;

import com.example.verbum.business.control.strategy.OrderByStrategy;
import com.example.verbum.business.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

public class OrderByBirthDate implements OrderByStrategy, Comparator<User> {
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
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d1 = sdf.parse(user.getBirthDate().toString());
            Date d2 = sdf.parse(t1.getBirthDate().toString());
            return d1.compareTo(d2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
