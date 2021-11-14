package com.example.volleyrecratetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<UserModel> users;
    RequestQueue queue;
    private String JSON_URL = "https://reqres.in/api/users?page=1";

    U_RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        RecyclerView recyclerView = findViewById(R.id.userList);
        users = new ArrayList<>();
        extractUsers();

        U_RecyclerViewAdapter adapter=new U_RecyclerViewAdapter(this,users);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void extractUsers() {


// Request a string response from the provided URL.
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray itemsArray = response.getJSONArray("data");
                            for (int i = 0; i < itemsArray.length(); i++) {
                                JSONObject singleUser = itemsArray.getJSONObject(i);
                                UserModel user = new UserModel();
                                user.setId(singleUser.getInt("id"));
                                user.setFrist_name(singleUser.getString("first_name"));
                                user.setLast_name(singleUser.getString("last_name"));
                                user.setEmail(singleUser.getString("email"));
                                user.setAvatar(singleUser.getString("avatar"));
                                users.add(user);
//                                Log.e("LifeCyCle",singleUser.toString());
//                                Toast.makeText(getApplicationContext(), book.toString(), Toast.LENGTH_LONG).show();

                            }

                        } catch (JSONException e) {
                            Log.d("Error In Parse",e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "SomeThing Went Wrong", Toast.LENGTH_LONG).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}