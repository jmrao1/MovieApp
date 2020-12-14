package com.movies.movieapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;


    MovieApi movieApi = new MovieApi();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.resultView);
        mQueue = Volley.newRequestQueue(this);

        Button seriesBtn = (Button) findViewById(R.id.seriesBtn);
        seriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText sText = (EditText) findViewById(R.id.movie_name);
                String searchText = sText.getText().toString();
                jsonParse(searchText, "s");
                closeKeyboard();
            }
        });

        Button titleIdBtn = (Button) findViewById(R.id.titleIdBtn);
        titleIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText sText = (EditText) findViewById(R.id.movie_name);
                String searchText = sText.getText().toString();
                jsonParse(searchText, "i");
                closeKeyboard();
            }
        });

        Button titleBtn = (Button) findViewById(R.id.titleBtn);
        titleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText sText = (EditText) findViewById(R.id.movie_name);
                String searchText = sText.getText().toString();
                jsonParse(searchText, "t");
                closeKeyboard();
            }
        });


    }

    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void jsonParse(String movieName, String type) {
        String url = movieApi.buildMovieUrl(movieName, type);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (type == "t" || type == "i") {
                            String response_parse = movieApi.title_json_data(response);
                            mTextViewResult.setText(response_parse);
                        } else {
                            String series_response_parse = movieApi.series_json_data(response);
                            mTextViewResult.setText(series_response_parse);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextViewResult.setText("ooh.. didn't work!");
            }
        });

// Add the request to the RequestQueue.
        mQueue.add(stringRequest);
    }

}