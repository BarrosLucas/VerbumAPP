package com.example.verbum.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbum.R;
import com.example.verbum.business.control.Validator;
import com.example.verbum.business.control.strategy.OrderByStrategy;
import com.example.verbum.business.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserItemAdapter extends RecyclerView.Adapter<UserItemAdapter.UserViewHolder> {
    List<User> users;

    public UserItemAdapter(ArrayList<User> pessoas){
        this.users = pessoas;
    }

    public UserItemAdapter(ArrayList<User> pessoas, OrderByStrategy orderBy){
        this.users = orderBy.order(pessoas);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        UserViewHolder pvh = new UserViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.username.setText(users.get(position).getUsername());
        holder.password.setText(users.get(position).getBirthDate().toString());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView username;
        TextView password;
        UserViewHolder(View itemView){
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.user_item);
            password = (TextView) itemView.findViewById(R.id.pass_item);
        }
    }
}