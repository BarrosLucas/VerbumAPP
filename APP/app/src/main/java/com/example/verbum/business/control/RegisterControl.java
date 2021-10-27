package com.example.verbum.business.control;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.MaskEdit;
import com.example.verbum.infra.utils.Verify;

import java.util.ArrayList;

public class RegisterControl {
    private EditText nameET;
    private EditText emailET;
    private EditText passwordET;
    private EditText confirmPassET;
    private EditText birthDateET;
    private EditText sexET;
    private ArrayList<User> users;
    private Context context;

    public RegisterControl(Context context){
        this.context = context;
    }

    public EditText getNameET() {
        return nameET;
    }

    public void setNameET(EditText nameET) {
        this.nameET = nameET;
    }

    public EditText getEmailET() {
        return emailET;
    }

    public void setEmailET(EditText emailET) {
        this.emailET = emailET;
    }

    public EditText getPasswordET() {
        return passwordET;
    }

    public void setPasswordET(EditText passwordET) {
        this.passwordET = passwordET;
    }

    public EditText getConfirmPassET() {
        return confirmPassET;
    }

    public void setConfirmPassET(EditText confirmPassET) {
        this.confirmPassET = confirmPassET;
    }

    public EditText getBirthDateET() {
        return birthDateET;
    }

    public void setBirthDateET(EditText birthDateET) {
        this.birthDateET = birthDateET;
        this.birthDateET.addTextChangedListener(MaskEdit.mask(birthDateET,MaskEdit.FORMAT_DATE));
    }

    public EditText getSexET() {
        return sexET;
    }

    public void setSexET(EditText sexET) {
        this.sexET = sexET;
        this.sexET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString();
                if(!s.equals(s.toUpperCase()))
                {
                    s=s.toUpperCase();
                    sexET.setText(s);
                    sexET.setSelection(sexET.length()); //fix reverse texting
                }
            }
        });
    }


    public String createNewUser(){
        if(!nameET.getText().toString().isEmpty()){
            if(!emailET.getText().toString().isEmpty()){
                if(!passwordET.getText().toString().isEmpty()){
                    if(!confirmPassET.getText().toString().isEmpty()){
                        if(!birthDateET.getText().toString().isEmpty()){
                            if(!sexET.getText().toString().isEmpty()){
                                if(emailET.getText().toString().length()>=3 && emailET.getText().toString().length()<=12){
                                    if(!emailET.getText().toString().matches(".*\\d.*")){
                                        if(nameET.getText().toString().length() >= 5){
                                            if(birthDateET.getText().toString().length()==10){
                                                if(sexET.getText().toString().equalsIgnoreCase("masculino") || sexET.getText().toString().equalsIgnoreCase("feminino")){
                                                    if(passwordET.getText().toString().length() >= 8 && passwordET.getText().toString().length()<=20){
                                                        if(Verify.howManyNumbers(passwordET.getText().toString()) >= 2 && passwordET.getText().length() > Verify.howManyNumbers(passwordET.getText().toString())){
                                                            if(passwordET.getText().toString().equals(confirmPassET.getText().toString())){
                                                                if(Verify.hasItem(users,emailET.getText().toString())==null){
                                                                    User user = new User(nameET.getText().toString(), emailET.getText().toString(), passwordET.getText().toString(), birthDateET.getText().toString(), sexET.getText().toString());
                                                                    updateList();
                                                                    users.add(user);
                                                                    if(newUser()){
                                                                        return "";
                                                                    }
                                                                    return "Houve uma falha para salvar seus dados";
                                                                }else{
                                                                    return "Esse nome de usuário já existe";
                                                                }
                                                            }else{
                                                                return "Senha e confirmação de senha devem ser iguais";
                                                            }
                                                        }else{
                                                            return "A senha deve conter letras e ao menos 2 números";
                                                        }
                                                    }else{
                                                        return "A senha deve conter entre 8 e 20 caracteres";
                                                    }
                                                }else{
                                                    return "O sexo deve ser feminino ou masculino";
                                                }
                                            }else{
                                                return "A data está inválida";
                                            }
                                        }else{
                                            return "Seu nome deve ter ao menos 5 caracteres";
                                        }
                                    }else{
                                        return "Seu nome de usuário não deve conter números";
                                    }
                                }else{
                                    return "Seu nome de usuário deve conter entre 3 e 12 caracteres";
                                }
                            }else{
                                return "Campo de sexo está vazio";
                            }
                        }else{
                            return "Data de nascimento está vazia";
                        }
                    }else{
                        return "Confirmação de senha está vazia";
                    }
                }else{
                    return "Senha está vazia";
                }
            }else{
                return "Nome de usuário está vazio";
            }
        }else{
            return "Seu nome está vazio";
        }
    }

    private void updateList(){
        UserPersistence userPersistence = new UserPersistence();
        users = userPersistence.load(context);
        if(users == null){
            users = new ArrayList<>();
        }
    }

    private boolean newUser(){
        UserPersistence userPersistence = new UserPersistence();
        return userPersistence.save(users,context);
    }
}
