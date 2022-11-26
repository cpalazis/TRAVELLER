package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


        Sights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent New_Screen=new Intent(getApplicationContext(),SightsActivity.class);
                //startActivity(New_Screen);
            }
        });
    }
}