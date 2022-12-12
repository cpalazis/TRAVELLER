package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
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
                //Put data in Information Activity
                Intent Info_Screen = new Intent(getApplicationContext(),Information.class);
                startActivity(Info_Screen);
            }
        });
        buttonCityName.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for New York
                //Put data in Information Activity
                Intent Info_Screen = new Intent(getApplicationContext(),Information.class);
                startActivity(Info_Screen);
            }
        });
        buttonCityName.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for Paris
                //Put data in Information Activity
                Intent Info_Screen = new Intent(getApplicationContext(),Information.class);
                startActivity(Info_Screen);
            }
        });
        buttonCityName.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for Rome
                //Put data in Information Activity
                Intent Info_Screen = new Intent(getApplicationContext(),Information.class);
                startActivity(Info_Screen);
            }
        });
        buttonCityName.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask informations for Tokyo
                //Put data in Information Activity
                Intent Info_Screen = new Intent(getApplicationContext(),Information.class);
                startActivity(Info_Screen);
            }
        });

    }

}