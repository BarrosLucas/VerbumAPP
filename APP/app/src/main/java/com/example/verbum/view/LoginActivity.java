package com.example.verbum.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.verbum.R;
import com.example.verbum.business.control.DoLoginCommand;
import com.example.verbum.business.control.LoginControl;
import com.example.verbum.business.control.RegisterControl;
import com.example.verbum.business.control.UserFacade;
import com.example.verbum.business.control.command.Switch;
import com.example.verbum.business.model.User;
import com.example.verbum.exception.EmptyUserException;
import com.example.verbum.infra.utils.Dialog;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    private AppCompatActivity context;
    EditText emailET;
    EditText passwordET;
    UserFacade facade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Switch switchInstance = Switch.getInstance();

        facade = new UserFacade(
                new LoginControl(getBaseContext()),null
        );
        context = this;

        emailET = (EditText) findViewById(R.id.login_et);
        passwordET = (EditText) findViewById(R.id.password_et);



        Button loginBt = (Button) findViewById(R.id.login_bt);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    User u = switchInstance.storeAndExecute((new DoLoginCommand(facade,
                            emailET.getText().toString(),
                            passwordET.getText().toString())));

                    Intent i = new Intent(getBaseContext(),HomeActivity.class);
                    i.putExtra("USER",u);
                    finish();
                    startActivity(i);

                } catch (IOException e) {
                    Dialog.showDialog("Login","Falha ao efetuar login",context);
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    Dialog.showDialog("Login","Falha ao efetuar login",context);
                    e.printStackTrace();
                } catch (EmptyUserException e) {
                    Dialog.showDialog("Login","Revise seus dados para login",context);
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ImageButton settings = (ImageButton) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),SettingsActivity.class);
                startActivity(intent);
            }
        });

        TextView newAccount = (TextView) findViewById(R.id.create_new_account);
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}