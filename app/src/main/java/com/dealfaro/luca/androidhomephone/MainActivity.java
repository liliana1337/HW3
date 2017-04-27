package com.dealfaro.luca.androidhomephone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button btnPost;
    private Button btnGet;
    private final String LOG_TAG = "androidhomephone";
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPost=(Button)findViewById(R.id.buttonPost);
        btnGet=(Button)findViewById(R.id.buttonGet);
        //mTextView = (TextView) findViewById(R.id.my_text);
        queue = Volley.newRequestQueue(this);
    }


    public void HandleClick(View view) {
        String url;
        final TextView mTextView = (TextView) findViewById(R.id.my_text);
        switch (view.getId()) {
            case R.id.buttonGet:
                // do get
                url ="https://luca-ucsc-teaching-backend.appspot.com/hw3/request_via_get?token=abracadabra";
                JsonObjectRequest jsObjRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                mTextView.setText("Response: " + response.toString());
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO Auto-generated method stub
                                Log.d(LOG_TAG, error.toString());
                            }
                        });
                queue.add(jsObjRequest);
                break;
            case R.id.buttonPost:
                // do post
                url ="https://luca-ucsc-teaching-backend.appspot.com/hw3/request_via_post?token=abracadabra";
                JsonObjectRequest jsObjRequestpost = new JsonObjectRequest
                        (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                mTextView.setText("Response: " + response.toString());
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO Auto-generated method stub
                                Log.d(LOG_TAG, error.toString());
                            }
                        });
                queue.add(jsObjRequestpost);
                break;
        }

    }

}

