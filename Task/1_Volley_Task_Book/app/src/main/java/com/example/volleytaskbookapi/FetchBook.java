package com.example.volleytaskbookapi;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

/**
 * FetchBook is an AsyncTask implementation that opens a network connection
 * and queryies the Book Service API.
 */
public class FetchBook extends AppCompatActivity {


    private static final String LOG_TAG = FetchBook.class.getSimpleName();

    // Constants for the various components of the Books API request.
    //
    // Base endpoint URL for the Books API.
    private static final String BOOK_BASE_URL =
            "https://www.googleapis.com/books/v1/volumes?";
    // Parameter for the search string.
    private static final String QUERY_PARAM = "q";
    // Parameter that limits search results.
    private static final String MAX_RESULTS = "maxResults";
    // Parameter to filter by print type.
    private static final String PRINT_TYPE = "printType";

    private String queryString;

    private RequestQueue mQueue;

    // Variables for the results TextViews.
    // These are WeakReferences to prevent "leaky context" -- weak references
    // enable the activity to be garbage collected if it is not needed.
    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;

    private Context context;

    // Constructor, provides references to the views in MainActivity.
    FetchBook(TextView titleText, TextView authorText,String queryString,Context context) {
        this.mTitleText = new WeakReference<>(titleText);
        this.mAuthorText = new WeakReference<>(authorText);
        this.queryString=queryString;
        this.context=context;
    }
    void getBookInfo(String queryString){
        Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
    }


//    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,builtURI.toString(), null, new Response.Listener<JSONObject>() {
//        @Override
//        public void onResponse(JSONObject response) {
//            try {
//                JSONArray jsonArray = response.getJSONArray("employees");
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject employee = jsonArray.getJSONObject(i);
//                    String firstName = employee.getString("name");
//                    int age = employee.getInt("age");
//                    String mail = employee.getString("email");
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//            error.printStackTrace();
//        }
//    });
}
