package com.example.front_end.utilities;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public class Service {
    final static String url = "http://localhost:3000/";

    public interface VolleyResponseListener {
        void onResponse(JSONObject jsonObject);
        void onResponse(JSONArray jsonArray);
        void onError(String message);
    }

    public void getJSONObject(Context context, String addUrl, String name, VolleyResponseListener volleyResponseListener){
        String Url = connectUrl(url, addUrl);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            volleyResponseListener.onResponse(response);
        }, error -> {volleyResponseListener.onError(name+" not found");});

        Singleton.getSingleton(context).addToRequestQueue(jsonObjectRequest);
    }

    public void getJSONArray(Context context, String addUrl, VolleyResponseListener volleyResponseListener){
        String Url = connectUrl(url, addUrl);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            volleyResponseListener.onResponse(response);
        }, error -> {volleyResponseListener.onError("There is no response!!!");});

        Singleton.getSingleton(context).addToRequestQueue(jsonArrayRequest);
    }


    private String connectUrl(String url, String addUrl) {
        if(addUrl == null) {
            return url;
        }
        else {
            return url + addUrl;
        }
    }
}
