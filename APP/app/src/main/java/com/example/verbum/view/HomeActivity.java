package com.example.verbum.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileUtils;
import android.widget.TextView;

import com.example.verbum.R;
import com.example.verbum.business.control.HomeControl;
import com.example.verbum.business.model.User;

public class HomeActivity extends AppCompatActivity {
    TextView name;
    TextView username;
    TextView pass;
    TextView birth;
    TextView sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("USER");

        name = (TextView) findViewById(R.id.name_home);
        username = (TextView) findViewById(R.id.user_home);
        pass = (TextView) findViewById(R.id.pass_home);
        birth = (TextView) findViewById(R.id.birth_home);
        sex = (TextView) findViewById(R.id.sex_home);

        name.setText(user.getName());
        username.setText(user.getUsername());
        pass.setText(user.getPassword());
        birth.setText(user.getBirthDate().toString());
        sex.setText(user.getSex().getSex());

    }
}