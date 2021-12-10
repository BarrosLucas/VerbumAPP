package com.example.verbum.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.verbum.R;
import com.example.verbum.business.control.SettingsControl;
import com.example.verbum.business.control.impl.strategy.OrderByBirthDate;
import com.example.verbum.business.control.impl.strategy.OrderByName;
import com.example.verbum.business.control.strategy.OrderByStrategy;
import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.Dialog;
import com.example.verbum.view.adapter.UserItemAdapter;
import com.tsuryo.swipeablerv.SwipeLeftRightCallback;
import com.tsuryo.swipeablerv.SwipeableRecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    SwipeableRecyclerView recyclerView;
    SettingsControl controller;
    AppCompatActivity context;
    LinearLayout nothing;
    TextView byBirth;
    TextView byUser;
    ImageView pdfButton;
    ImageView imgButton;

    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        byBirth = (TextView) findViewById(R.id.order_birth);
        byUser = (TextView) findViewById(R.id.order_name);

        pdfButton = (ImageView) findViewById(R.id.pdf_generator);
        imgButton = (ImageView) findViewById(R.id.img_generator);

        byBirth.setOnClickListener(v-> orderBy(new OrderByBirthDate(), users));
        byUser.setOnClickListener(v->orderBy(new OrderByName(), users));

        pdfButton.setOnClickListener(v-> pdfGenerator());
        imgButton.setOnClickListener(v-> imgGenerator());

        controller = new SettingsControl(getBaseContext());
        context = this;

        recyclerView = (SwipeableRecyclerView) findViewById(R.id.rv);
        nothing = (LinearLayout) findViewById(R.id.nothing);

        try {
            users = controller.getUsers();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        updatePage(users);
        UserItemAdapter adapter = new UserItemAdapter(users);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setListener(new SwipeLeftRightCallback.Listener() {
            @Override
            public void onSwipedLeft(int position) {
                try {
                    if (controller.delete(users.get(position).getUsername())) {
                        updatePage(controller.getUsers());
                        UserItemAdapter adapter = new UserItemAdapter(controller.getUsers());
                        recyclerView.setAdapter(adapter);
                        Dialog.showDialog("Operação realizada com sucesso!", "O usuário informado foi excluído com sucesso", context);
                    } else {
                        Dialog.showDialog("Falha na operação", "O usuário não foi excluído", context);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Dialog.showDialog("Falha na operação", "O usuário não foi excluído", context);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    Dialog.showDialog("Falha na operação", "O usuário não foi excluído", context);
                }
            }

            @Override
            public void onSwipedRight(int position) {

            }
        });
    }

    private void updatePage(ArrayList<User> users) {
        if (users != null) {
            if (users.isEmpty()) {
                recyclerView.setVisibility(View.GONE);
                nothing.setVisibility(View.VISIBLE);
            } else {
                recyclerView.setVisibility(View.VISIBLE);
                nothing.setVisibility(View.GONE);
            }
        } else {
            recyclerView.setVisibility(View.GONE);
            nothing.setVisibility(View.VISIBLE);
        }
    }

    private void orderBy(OrderByStrategy order, ArrayList<User> users){
        UserItemAdapter adapter = new UserItemAdapter(users, order);
        recyclerView.setAdapter(adapter);
    }

    private void pdfGenerator(){
        try {
            controller.createPDF();
        } catch (IOException e) {
            e.printStackTrace();
            Dialog.showDialog("Falha na criação do PDF","O PDF não pôde ser criado",this);
        }
    }

    private void imgGenerator(){
        try {
            controller.createIMG();
        } catch (Exception e) {
            e.printStackTrace();
            Dialog.showDialog("Falha na criação da página","A página HTML não pôde ser criada",this);
        }
    }

}