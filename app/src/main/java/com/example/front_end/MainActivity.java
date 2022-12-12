package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.example.front_end.objects.*;
import com.example.front_end.utilities.Service;
import com.example.front_end.utilities.UtilityClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button exit, search, top;
    Service service = new Service();
    Gson gson = new Gson();
    ArrayList list = new ArrayList();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exit = findViewById(R.id.button_exit);
        search = findViewById(R.id.button_search);
        top = findViewById(R.id.button_top_cities);

        exit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        search.setOnClickListener(v-> {

        });

        top.setOnClickListener(v -> {
            service.getJSONArray(this, "topCities", new Service.VolleyResponseListener() {
                @Override
                public void onResponse(JSONObject jsonObject) {

                }

                @Override
                public void onResponse(JSONArray jsonArray) {
                    list = gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Town>>(){}.getType());
                    UtilityClass.getInstance().setList(list);


                }

                @Override
                public void onError(String message) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            });
        });

    }


}