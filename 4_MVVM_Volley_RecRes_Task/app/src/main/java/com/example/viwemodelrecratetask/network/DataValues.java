package com.example.viwemodelrecratetask.network;

import android.content.Context;

import com.android.volley.VolleyError;
import com.example.viwemodelrecratetask.model.User;

import org.json.JSONObject;

import java.util.List;

interface DataValues {

    public List<User>  getUserList(Context context);
}