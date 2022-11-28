package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class TownsActivity extends AppCompatActivity {
    private List<ImageView> imageCityName = new ArrayList<>();
    private List<Button> buttonCityName = new ArrayList<>();
    private List<String> cityNames = new ArrayList<>();

    public TownsActivity() {
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towns);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageCityName.add(findViewById(R.id.imagePopular1));
        imageCityName.add(findViewById(R.id.imagePopular2));
        imageCityName.add(findViewById(R.id.imagePopular3));
        imageCityName.add(findViewById(R.id.imagePopular4));

        buttonCityName.add(findViewById(R.id.buttonPopular1));
        buttonCityName.add(findViewById(R.id.buttonPopular2));
        buttonCityName.add(findViewById(R.id.buttonPopular3));
        buttonCityName.add(findViewById(R.id.buttonPopular4));


        citiesResult();
    }

    public void citiesResult()  {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest response = new StringRequest(Request.Method.GET, "https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8?fbclid=IwAR0tZoLu2jWWK7gUDZdNw6Sd1aZSiAYq9en4suQqVpdcLTvSnXQyxKQLmW4",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length() ; i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                cityNames.add(jsonObject.getString("city"));
                            }
                            displayResults();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }

        );
        queue.add(response);
    }

    public  void displayResults(){
        for(int i = 0; i < cityNames.size(); i++){
            buttonCityName.get(i).setText(cityNames.get(i));
        }
    }
}