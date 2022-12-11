package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class TopFive extends AppCompatActivity {
    private List<Button> buttonPlaceName = new ArrayList<>();

    public TopFive() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five);


        //start the code from here
        setTitle("Top 5 Places Activity");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonPlaceName.add(findViewById(R.id.buttonPlace1));
        buttonPlaceName.add(findViewById(R.id.buttonPlace2));
        buttonPlaceName.add(findViewById(R.id.buttonPlace3));
        buttonPlaceName.add(findViewById(R.id.buttonPlace4));
        buttonPlaceName.add(findViewById(R.id.buttonPlace5));

        Intent Display_Screen = new Intent(getApplicationContext(),Display.class);

        buttonPlaceName.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////Put data in Display Activity for 1st place
                startActivity(Display_Screen);
            }
        });
        buttonPlaceName.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////Put data in Display Activity for 2nd place
                startActivity(Display_Screen);
            }
        });
        buttonPlaceName.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////Put data in Display Activity for 3rd place
                startActivity(Display_Screen);
            }
        });
        buttonPlaceName.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////Put data in Display Activity for 4th place
                startActivity(Display_Screen);
            }
        });
        buttonPlaceName.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////Put data in Display Activity for 5th place
                startActivity(Display_Screen);
            }
        });

    }
}