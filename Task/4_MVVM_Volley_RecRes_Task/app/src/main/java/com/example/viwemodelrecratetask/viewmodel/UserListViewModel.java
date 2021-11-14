package com.example.viwemodelrecratetask.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.viwemodelrecratetask.model.User;
import com.example.viwemodelrecratetask.network.VolleyInstance;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserListViewModel extends ViewModel {

    public static String BASE_URL = "https://reqres.in/api/";//volley_array.json
    private RequestQueue requestQueue;
    private List<User> users = new ArrayList<>();
    private MutableLiveData<List<User>> userList;
    JSONObject postData = new JSONObject();


    public UserListViewModel() {
        userList = new MutableLiveData<>();
    }


    public MutableLiveData<List<User>> getUserObservable() {
        return userList;
    }

    public void extractUsers(Context context) {
// Request a string response from the provided URL.
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL + "users?page=1", null,
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
                                userList.postValue(users);
                            }
                        } catch (JSONException e) {
                            Log.e("ErrorIn Call", e.getMessage());
                            userList.postValue(null);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error in ViewModel", error.getMessage());
            }
        });

// Add the request to the RequestQueue.
        requestQueue = VolleyInstance.getInstance(context).getRequestQueue();
        requestQueue.add(stringRequest);

    }

    public void loginUser(Context context) {
        try {
            postData.put("email", "eve.holt@reqres.in");
            postData.put("password", "cityslicka");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, BASE_URL + "login",
                postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue = VolleyInstance.getInstance(context).getRequestQueue();
        requestQueue.add(jsonObjectRequest);
    }

    public void updateUser(Context context) {
        try {
            postData.put("name", "morpheus");
            postData.put("job", "zion resident");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.PUT, BASE_URL + "users/2", postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // response
                        Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        );
        requestQueue = VolleyInstance.getInstance(context).getRequestQueue();
        requestQueue.add(putRequest);
    }

}
