package com.example.verbum.business.model;

public class Woman implements Sex{
    private String sex;
    public Woman(){
        this.sex = "Woman";
    }

    @Override
    public String getSex() {
        return sex;
    }
}
