package com.example.hello_world;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View view) {
        Uri uri = null;
        switch (view.getId())
        {

            case R.id.b1:
                Log.i("MainActivity","Hello World");
                uri=Uri.parse("geo:20.5937,78.9629");
                break;
            case R.id.b2:
                Log.i("MainActivity","Hello World");
                uri=Uri.parse("tel:7291240747");
                break;
            case R.id.b3:
                uri=Uri.parse("https://www.google.com");
                break;
        }
        
        Intent intent =new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}