package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.front_end.objects.*;
import com.example.front_end.utilities.Service;
import com.example.front_end.utilities.UtilityClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button exit, top, search;
    private EditText editText;
    Gson gson = new Gson();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




       exit = findViewById(R.id.button_exit);
       top = findViewById(R.id.button_top_cities);
       search = findViewById(R.id.button_search);
       editText = findViewById(R.id.editText_findCity);

       exit.setOnClickListener(v -> {
          finish();
          System.exit(0);
        });

       top.setOnClickListener(v -> {
           Service service = new Service();
           service.getJSONArray(this, "topCities", new Service.VolleyResponseListener() {
               @Override
               public void onResponse(JSONObject jsonObject) {

               }

               @Override
               public void onResponse(JSONArray jsonArray) {
                    ArrayList<Town> list = new ArrayList<>();
                    list = gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Town>>(){}.getType());
                    UtilityClass.getInstance().setList(list);
                    Intent intent = new Intent(MainActivity.this, TopFive.class);
                    startActivity(intent);
               }

               @Override
               public void onError(String message) {
                   Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
               }
           });
       });

       search.setOnClickListener(v -> {
           Service service = new Service();
                   service.getJSONObject(this, editText.getText().toString(), new Service.VolleyResponseListener() {
               @Override
               public void onResponse(JSONObject jsonObject) {
                   ArrayList<Town> town  = new ArrayList<>();
                   town.add(gson.fromJson(String.valueOf(jsonObject), Town.class));
                   UtilityClass.getInstance().setList(town);
                   Intent intent = new Intent(MainActivity.this, Information.class);
                   startActivity(intent);
               }

               @Override
               public void onResponse(JSONArray jsonArray) {

               }

               @Override
               public void onError(String message) {
                   Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
               }
           });
       });
    }
}