package com.example.userinput;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox ch1,ch2;
    RadioButton r1,r2;
    EditText t1,t2;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch1 =(CheckBox)findViewById(R.id.ch1);
        toggleButton =(ToggleButton)findViewById(R.id.toggleButton);

        ch2=(CheckBox)findViewById(R.id.ch2);
        ch1.setOnCheckedChangeListener(new  CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"You CLicked on YES",Toast.LENGTH_LONG).show();
            }
        } );
        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"You CLicked on No",Toast.LENGTH_LONG).show();

            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked())
                {
                    Toast.makeText(MainActivity.this,"You Have Checked Toggle Button",Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(MainActivity.this,"You Have UnChecked Toggle Button",Toast.LENGTH_LONG).show();

            }
        });
    }

    public void showAlert(View view) {
        AlertDialog.Builder myalert=new AlertDialog.Builder(this);
        myalert.setTitle("Exit");
        myalert.setMessage("Are You Sure?");
        myalert.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        myalert.setNegativeButton("No:)", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        myalert.setCancelable(false);
        myalert.show();
    }
}