package com.example.verbum.business.model;

public class Woman implements Sex{
    private static final long serialVersionUID = 1L;
    private String sex;
    public Woman(){
        this.sex = "Woman";
    }

    @Override
    public String getSex() {
        return sex;
    }
}
