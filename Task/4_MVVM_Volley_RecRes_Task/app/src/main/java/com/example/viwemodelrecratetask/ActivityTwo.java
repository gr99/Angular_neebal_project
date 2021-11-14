package com.example.viwemodelrecratetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.viwemodelrecratetask.model.User;
import com.example.viwemodelrecratetask.viewmodel.UserListViewModel;

import java.util.List;

public class ActivityTwo extends AppCompatActivity {
    ImageView avatar;
    TextView titleView;
    Button postButton;
    Button putButton;
    private UserListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String image = extras.getString("image");

        avatar = findViewById(R.id.avatarImageCircle);
        titleView = findViewById(R.id.titleView2);
        postButton = findViewById(R.id.postButton);
        putButton = findViewById(R.id.putButton);
        viewModel = ViewModelProviders.of(this).get(UserListViewModel.class);


        Glide.with(this)
                .load(image)
                .into(avatar);

        titleView.setText(name);
    }

    public void onClickLogin(View view) {
        viewModel.loginUser(this);
    }

    public void onCLickUpdate(View view) {
        viewModel.updateUser(this);
    }
}