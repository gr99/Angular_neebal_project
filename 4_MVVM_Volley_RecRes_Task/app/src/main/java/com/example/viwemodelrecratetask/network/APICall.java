package com.example.viwemodelrecratetask.network;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.viwemodelrecratetask.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class APICall implements DataValues {
    public static String BASE_URL = "https://reqres.in/api/users?page=1";//volley_array.json
    private RequestQueue requestQueue;

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getUserList(Context context) {
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray itemsArray = response.getJSONArray("data");
                            users.clear();

                            for (int i = 0; i < itemsArray.length(); i++) {
                                JSONObject singleUser = itemsArray.getJSONObject(i);
//                                Log.e("LifeCyCle",singleUser.toString());
                                User user = new User();
                                user.setId(singleUser.getInt("id"));
                                user.setFrist_name(singleUser.getString("first_name"));
                                user.setLast_name(singleUser.getString("last_name"));
                                user.setEmail(singleUser.getString("email"));
                                user.setAvatar(singleUser.getString("avatar"));
                                users.add(user);
                            }

                        } catch (JSONException e) {
                            Log.e("ErrorIn Call", e.getMessage());
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error in ViewModel", error.getMessage());
            }
        });
        requestQueue = VolleyInstance.getInstance(context).getRequestQueue();
        requestQueue.add(stringRequest);
        return users;

    }

}
