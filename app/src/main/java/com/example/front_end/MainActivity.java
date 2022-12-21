package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.front_end.objects.Foo;
import com.example.front_end.utilities.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String url = "https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8";
    private static final String uncorrectUrl = "https://mocki.io/v1/d4867d8b-b5d5-4a48-79131b5809b8";
    ArrayList<TextView> cities = new ArrayList<>();
    ArrayList<TextView> names = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button correctUrl, wrongUrl, clear;


        correctUrl = findViewById(R.id.button_right);
        wrongUrl = findViewById(R.id.button_wrong);
        clear = findViewById(R.id.button_clear);

        cities.add(0, findViewById(R.id.textView_1));
        cities.add(1, findViewById(R.id.textView_2));
        cities.add(2, findViewById(R.id.textView_3));
        cities.add(3, findViewById(R.id.textView_4));
        names.add(0, findViewById(R.id.textView_5));
        names.add(1, findViewById(R.id.textView_6));
        names.add(2, findViewById(R.id.textView_7));
        names.add(3, findViewById(R.id.textView_8));

        correctUrl.setOnClickListener(v -> {
            getJsonResponse(url);
        });

        wrongUrl.setOnClickListener(v -> {
            getJsonResponse(uncorrectUrl);
        });

        clear.setOnClickListener(v -> {
            clearAllTheText();
        });
    }

    private void clearAllTheText() {
        for(int i = 0; i < cities.size(); i++){
            cities.get(i).setText("");
            names.get(i).setText("");
        }
    }

    private void getJsonResponse(String string) {
        Service service = new Service();
        service.getJSONArray(this, string, new Service.VolleyResponseListener() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                
            }

            @Override
            public void onResponse(JSONArray jsonArray) {
                ArrayList<Foo> foos = setFooList(jsonArray);
                setArrayyToLayout(foos);
                
            }

            @Override
            public void onError(String message) {
                showErrorMessage(message);
            }
        });
    }

    private void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void setArrayyToLayout(ArrayList<Foo> foos) {
        for(int i = 0; i < foos.size(); i++){
            cities.get(i).setText(foos.get(i).getCity());
            names.get(i).setText(foos.get(i).getName());
        }
    }

    private ArrayList<Foo> setFooList(JSONArray jsonArray) {
        Gson gson = new Gson();
        return gson.fromJson(String.valueOf(jsonArray),  new TypeToken<ArrayList<Foo>>(){}.getType());
    }

}