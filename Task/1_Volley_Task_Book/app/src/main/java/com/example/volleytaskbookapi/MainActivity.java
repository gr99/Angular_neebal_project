package com.example.volleytaskbookapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
        Button buttonParse = findViewById(R.id.searchButton);


        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mAuthorText.setText("Parsing");
                jsonParse(v);
            }
        });

    }
//Need ReFactoring
    private static final String BOOK_BASE_URL =
            "https://www.googleapis.com/books/v1/volumes?";
    // Parameter for the search string.
    private static final String QUERY_PARAM = "q";
    // Parameter that limits search results.
    private static final String MAX_RESULTS = "maxResults";
    // Parameter to filter by print type.
    private static final String PRINT_TYPE = "printType";


    private void jsonParse(View view) {

        String queryString = mBookInput.getText().toString();

        Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, queryString)
                .appendQueryParameter(MAX_RESULTS, "10")
                .appendQueryParameter(PRINT_TYPE, "books")
                .build();

    //Hide keyBoard after input.
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        // Check the status of the network connection.
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        // If the network is available,perform task.
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {

//            Main Code Goes Here...

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, builtURI.toString(), null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray itemsArray = response.getJSONArray("items");
                        // Initialize iterator and results fields.
                        int i = 0;
                        String title = null;
                        String authors = null;
                        while (i < itemsArray.length() &&
                                (authors == null && title == null)) {
                            // Get the current item information.
                            JSONObject book = itemsArray.getJSONObject(i);
                            JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                            // Try to get the author and title from the current item,
                            // catch if either field is empty and move on.
                            try {
                                title = volumeInfo.getString("title");
                                authors = volumeInfo.getString("authors");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            // Move to the next item.
                            i++;
                        }
                        // If both are found, display the result.
                        if (title != null && authors != null) {
                            mTitleText.setText(title);
                            mAuthorText.setText(authors);
                        } else {
                            // If none are found, update the UI to show failed results.
                            mTitleText.setText(R.string.no_results);
                            mAuthorText.setText("");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mTitleText.setText(R.string.no_results);
                    mAuthorText.setText("");
                    error.printStackTrace();
                }
            });

            mQueue.add(request);


            mAuthorText.setText("");
            mTitleText.setText(R.string.loading);
        }
        // Otherwise update the TextView to tell the user there is no
        // connection, or no search term.
        else {
            if (queryString.length() == 0) {
                mAuthorText.setText("");
                mTitleText.setText(R.string.no_search_term);
            } else {
                mAuthorText.setText("");
                mTitleText.setText(R.string.no_network);
            }
        }
    }
}