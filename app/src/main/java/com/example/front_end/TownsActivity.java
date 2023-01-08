package com.example.front_end;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.front_end.dictionary.Words;
import com.example.front_end.utilities.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TownsActivity extends AppCompatActivity {
    private List<Button> buttonCityName = new ArrayList<>();




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towns);

        //start the code from here
        setTitle("Top 5 Cities Activity");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonCityName.add(findViewById(R.id.buttonLondon));
        buttonCityName.add(findViewById(R.id.buttonNewYork));
        buttonCityName.add(findViewById(R.id.buttonParis));
        buttonCityName.add(findViewById(R.id.buttonRome));
        buttonCityName.add(findViewById(R.id.buttonTokyo));



        buttonCityName.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for London

                HashMap<String, Words> map = new HashMap<>();
                map.put("London",Words.TOWN);
                map.put("Information",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                //intent.putExtra("city","London");
                //intent.putExtra("place","");
                //intent.putExtra("activity","Information");
                //startActivity(intent);
            }
        });
        buttonCityName.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for New York

                HashMap<String, Words> map = new HashMap<>();
                map.put("New York",Words.TOWN);
                map.put("Information",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        buttonCityName.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for Paris

                HashMap<String, Words> map = new HashMap<>();
                map.put("Paris",Words.TOWN);
                map.put("Information",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                }
        });
        buttonCityName.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for Rome

                HashMap<String, Words> map = new HashMap<>();
                map.put("Rome",Words.TOWN);
                map.put("Information",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        buttonCityName.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for Tokyo

                HashMap<String, Words> map = new HashMap<>();
                map.put("Tokyo",Words.TOWN);
                map.put("Information",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

    }

}