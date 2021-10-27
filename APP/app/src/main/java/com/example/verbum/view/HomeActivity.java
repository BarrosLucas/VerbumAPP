package com.example.verbum.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.verbum.R;
import com.example.verbum.business.control.HomeControl;
import com.example.verbum.business.model.User;

public class HomeActivity extends AppCompatActivity {

    HomeControl controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("USER");

        controller = new HomeControl(user);

        controller.setName((TextView) findViewById(R.id.name_home));
        controller.setUser((TextView) findViewById(R.id.user_home));
        controller.setPass((TextView) findViewById(R.id.pass_home));
        controller.setBirth((TextView) findViewById(R.id.birth_home));
        controller.setSex((TextView) findViewById(R.id.sex_home));

    }
}