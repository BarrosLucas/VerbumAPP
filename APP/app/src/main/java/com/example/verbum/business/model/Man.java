package com.example.verbum.business.model;

public class Man implements Sex {
    private static final long serialVersionUID = 1L;
    private String sex;
    public Man(){
        this.sex = "Man";
    }

    @Override
    public String getSex() {
        return sex;
    }
}
