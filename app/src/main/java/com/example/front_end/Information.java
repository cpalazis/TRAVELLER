package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Button Museums;
        Button Hotels;
        Button Banks;
        Button Caffe;
        Button Photos;
        Button Restaurants;
        Button Sights;
        Button General_Informations;


        Museums =findViewById(R.id.button);
        Hotels =findViewById(R.id.button2);
        Banks=findViewById(R.id.button3);
        Caffe=findViewById(R.id.button4);
        Photos=findViewById(R.id.button5);
        Restaurants=findViewById(R.id.button6);
        Sights=findViewById(R.id.button7);
        General_Informations=findViewById(R.id.button8);


        Intent Top_Screen=new Intent(getApplicationContext(),TopFive.class);

        //Handle button Museums---------------------------------
        Museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Put data in TopFive Activity for top 5 museums

                startActivity(Top_Screen);
            }
        });

        //Handle button Hotels---------------------------------
        Hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Put data in TopFive Activity for top 5 hotels

                startActivity(Top_Screen);
            }
        });

        //Handle button Banks---------------------------------
        Banks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Put data in TopFive Activity for top 5 banks

                startActivity(Top_Screen);
            }
        });

        //Handle button Caffe---------------------------------
        Caffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Put data in TopFive Activity for top 5 caffe

                startActivity(Top_Screen);
            }
        });

        //Handle button Restaurants---------------------------------
        Restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Put data in TopFive Activity for top 5 restaurants

                startActivity(Top_Screen);
            }
        });

        //Handle button Sights---------------------------------
        Sights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Put data in TopFive Activity for top 5 sights

                startActivity(Top_Screen);
            }
        });


        //Handle button General_Informations---------------------------------
        Intent Disp_Screen=new Intent(getApplicationContext(),Display.class);

        General_Informations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Put data in Display Activity
                // Insert general information for the city who looking for
                //and one famous photo

                startActivity(Disp_Screen);
            }
        });


        //Handle button Photos---------------------------------
        Intent Photos_Screen=new Intent(getApplicationContext(),Photos.class);

        Photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Put data in Photos Activity
                // Insert the 12 famous photos for the city who looking for

                startActivity(Photos_Screen);
            }
        });
    }
}