package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);

        registerForContextMenu(e1);
        registerForContextMenu(e2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.m1:
                Toast.makeText(getApplicationContext(),
                        "Clicked Settings",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.m2:
                Toast.makeText(getApplicationContext(),
                        "Clicked",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.editcontext,menu);
        switch (v.getId()){
            case R.id.e1:
                getMenuInflater().inflate(R.menu.editcontext,menu);
                break;
            case R.id.e2:
                getMenuInflater().inflate(R.menu.editcontexttwo,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.i1:
                Toast.makeText(getApplicationContext(),
                        "I1",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.i2:Toast.makeText(getApplicationContext(),
                    "I2",
                    Toast.LENGTH_LONG).show();
            break;
            case R.id.i4:
                Toast.makeText(getApplicationContext(),
                        "i4",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.i5:Toast.makeText(getApplicationContext(),
                    "I5",
                    Toast.LENGTH_LONG).show();

        }
        return true;
    }
}