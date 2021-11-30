package com.example.verbum.business.model;

public class Man implements Sex {
    private String sex;
    public Man(){
        this.sex = "Man";
    }

    @Override
    public String getSex() {
        return sex;
    }
}
