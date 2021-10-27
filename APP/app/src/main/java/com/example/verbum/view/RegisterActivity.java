package com.example.verbum.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.verbum.R;
import com.example.verbum.business.control.RegisterControl;
import com.example.verbum.infra.utils.Dialog;

public class RegisterActivity extends AppCompatActivity {
    private RegisterControl controller;
    private AppCompatActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        controller = new RegisterControl(getBaseContext());
        context = this;

        controller.setNameET((EditText) findViewById(R.id.name_et));
        controller.setEmailET((EditText) findViewById(R.id.user_et));
        controller.setPasswordET((EditText) findViewById(R.id.pass_et));
        controller.setConfirmPassET((EditText) findViewById(R.id.confirm_pass_et));
        controller.setBirthDateET((EditText) findViewById(R.id.birth_et));
        controller.setSexET((EditText) findViewById(R.id.sex_et));
        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ret = controller.createNewUser();
                if(ret.isEmpty()){
                    Dialog.showDialog("Cadastro Realizado!","Seu cadastro foi realizado com sucesso",context);
                    finish();
                }else{
                    Dialog.showDialog("Falha no cadastro",ret,context);
                }
            }
        });
    }
}