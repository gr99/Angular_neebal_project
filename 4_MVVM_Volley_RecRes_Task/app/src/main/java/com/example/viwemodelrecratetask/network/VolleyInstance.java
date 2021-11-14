package com.example.viwemodelrecratetask.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyInstance {

    private static VolleyInstance mInstance;
    private RequestQueue requestQueue;

    public VolleyInstance(Context ctx) {
        this.requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
    }

    public static synchronized VolleyInstance getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyInstance(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
