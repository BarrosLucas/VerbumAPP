package com.example.verbum.business.control.factory;

import com.example.verbum.business.model.Man;
import com.example.verbum.business.model.Sex;
import com.example.verbum.business.model.Woman;

public class SexFactory {
    public enum Type{
        WOMAN, MAN
    }

    public Sex getSex(int sex){
        if(sex == Type.WOMAN.ordinal()){
            return new Woman();
        }else if(sex == Type.MAN.ordinal()){
            return new Man();
        }
        throw new IllegalArgumentException("Não foi definido sexo biológico");
    }

    public Sex getSexByText(String sex){
        if(sex.equalsIgnoreCase("feminino")){
            return new Woman();
        }else if(sex.equalsIgnoreCase("masculino")){
            return new Man();
        }
        throw new IllegalArgumentException("Não foi definido sexo biológico");
    }
}
