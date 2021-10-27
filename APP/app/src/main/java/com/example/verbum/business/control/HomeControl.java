package com.example.verbum.business.control;

import android.widget.TextView;

import com.example.verbum.business.model.User;

public class HomeControl {
    private TextView name;
    private TextView user;
    private TextView pass;
    private TextView birth;
    private TextView sex;

    private User userLogin;

    public HomeControl(User user){
        this.userLogin = user;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
        this.name.setText(userLogin.getName());
    }

    public TextView getUser() {
        return user;
    }

    public void setUser(TextView user) {
        this.user = user;
        this.user.setText(userLogin.getUsername());
    }

    public TextView getPass() {
        return pass;
    }

    public void setPass(TextView pass) {
        this.pass = pass;
        this.pass.setText(userLogin.getPassword());
    }

    public TextView getBirth() {
        return birth;
    }

    public void setBirth(TextView birth) {
        this.birth = birth;
        this.birth.setText(userLogin.getBirthDate());
    }

    public TextView getSex() {
        return sex;
    }

    public void setSex(TextView sex) {
        this.sex = sex;
        this.sex.setText(userLogin.getSex());
    }
}
