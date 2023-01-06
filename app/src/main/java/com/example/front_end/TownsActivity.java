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

    public TownsActivity() {
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towns);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonCityName.add(findViewById(R.id.buttonLondon));

        buttonCityName.add(findViewById(R.id.buttonNewYork));

        buttonCityName.add(findViewById(R.id.buttonParis));

        buttonCityName.add(findViewById(R.id.buttonRome));

        buttonCityName.add(findViewById(R.id.buttonTokyo));

        buttonCityName.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent london = new Intent(getApplicationContext(),LondonActivity.class);
                startActivity(london);
            }
        });

        buttonCityName.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newYork = new Intent(getApplicationContext(),NewYorkActivity.class);
                startActivity(newYork);
            }
        });

        buttonCityName.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paris = new Intent(getApplicationContext(),ParisActivity.class);
                startActivity(paris);
            }
        });

        buttonCityName.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rome = new Intent(getApplicationContext(),RomeActivity.class);
                startActivity(rome);
            }
        });

        buttonCityName.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tokyo = new Intent(getApplicationContext(),TokyoActivity.class);
                startActivity(tokyo);
            }
        });

    }

}