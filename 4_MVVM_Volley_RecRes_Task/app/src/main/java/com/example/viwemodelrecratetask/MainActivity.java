package com.example.viwemodelrecratetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.example.viwemodelrecratetask.adapter.UserListAdapter;
import com.example.viwemodelrecratetask.model.User;
import com.example.viwemodelrecratetask.viewmodel.UserListViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserListAdapter.ItemClickListener {

    private List<User> userModelList;
    private UserListAdapter adapter;
    private UserListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        adapter = new UserListAdapter(this, userModelList, this);
        viewModel.extractUsers(this);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
//        adapter = new UserListAdapter(this, userModelList);
        
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel.getUserObservable().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> userList) {
                Log.e("LifeCyCle", "Changed");
                if (userList != null) {
                    userModelList = userList;
                    adapter.setUserListAdapter(userModelList);
                }
            }
        });
    }


    @Override
    public void onUserClick(User user) {
        Intent i = new Intent(getApplicationContext(), ActivityTwo.class);
//        Toast.makeText(this,"Hii there", Toast.LENGTH_SHORT).show();
        i.putExtra("name", user.getFrist_name() + " " + user.getLast_name());
        i.putExtra("image", user.getAvatar());

        startActivity(i);
    }
}