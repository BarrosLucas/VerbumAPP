package com.example.verbum.business.model;

import java.io.Serializable;
import java.util.Comparator;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private String username;
    private String password;
    private Date birthDate;
    private String sex;

    public User(){

    }
    public User(String name, String username, String password, Date birthDate, String sex){
        this.name = name;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        String[] date = birthDate.split("/");
        this.birthDate = new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}