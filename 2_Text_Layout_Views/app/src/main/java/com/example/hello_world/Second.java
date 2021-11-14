package com.example.hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Get Variable
        Bundle b1=getIntent().getExtras();
        String s1=b1.getString("user");
        t1=(TextView) findViewById(R.id.viewText);
        t1.setText(s1);
    }
}