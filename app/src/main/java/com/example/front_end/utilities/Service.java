package com.example.front_end.utilities;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class Service {
    private static final String url = "https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8";

    public interface VolleyResponseListener {
        void onResponse(JSONObject jsonObject);

        void onResponse(JSONArray jsonArray);

        void onError(String message);
    }

    public void getJSONObject(Context context, String url, VolleyResponseListener volleyResponseListener) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            volleyResponseListener.onResponse(response);
        }, error -> {
            volleyResponseListener.onError("Your request does not found.");
        });

        Singleton.getSingleton(context).addToRequestQueue(jsonObjectRequest);
    }

    public void getJSONArray(Context context, String url, VolleyResponseListener volleyResponseListener) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            volleyResponseListener.onResponse(response);
        }, error -> {
            volleyResponseListener.onError("Your request does not exist.");
        });

        Singleton.getSingleton(context).addToRequestQueue(jsonArrayRequest);
    }
}
