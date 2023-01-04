package com.example.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.front_end.dictionary.Words;
import com.example.front_end.objects.Town;
import com.example.front_end.utilities.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;

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

        //TextView infoTxt shows the name of the city
        TextView infoTxt = findViewById(R.id.textView);

        ArrayList<Town> town = UtilityClass.getInstance().getTownList();
        String cityName="";


        if (town != null){
            infoTxt.setText(town.get(0).getName());
            cityName=town.get(0).getName();
        }



        //Handle button Museums---------------------------------
        String finalCityName = cityName;
        Museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Words> map = new HashMap<>();
                map.put("museums",Words.SENDARRAYMUSEUM);
                map.put(finalCityName,Words.TOWN);
                map.put("TopFive",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);


                //Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                //intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                //intent.putExtra("place","Museums");  //the name of place
                //intent.putExtra("activity","TopFive"); //Put data in TopFive Activity for top 5 museums
                //startActivity(intent);

            }
        });

        //Handle button Hotels---------------------------------
        Hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Words> map = new HashMap<>();
                map.put("hotels",Words.SENDARRAYHOTEL);
                map.put(finalCityName,Words.TOWN);
                map.put("TopFive",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

        //Handle button Banks---------------------------------
        Banks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Words> map = new HashMap<>();
                map.put("banks",Words.SENDARRAYBANK);
                map.put(finalCityName,Words.TOWN);
                map.put("TopFive",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

        //Handle button Caffe---------------------------------
        Caffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Words> map = new HashMap<>();
                map.put("caffe",Words.SENDCOFFEESHOP);
                map.put(finalCityName,Words.TOWN);
                map.put("TopFive",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

        //Handle button Restaurants---------------------------------
        Restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Words> map = new HashMap<>();
                map.put("restaurants",Words.SENDARRAYRESTAURANT);
                map.put(finalCityName,Words.TOWN);
                map.put("TopFive",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

        //Handle button Sights---------------------------------
        Sights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Words> map = new HashMap<>();
                map.put("sights",Words.SENDARRAYSIGHT);
                map.put(finalCityName,Words.TOWN);
                map.put("TopFive",Words.ACTIVITY);
                UtilityClass.getInstance().setMapList(map);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });


        //Handle button General_Informations---------------------------------
        General_Informations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Display.class);
                startActivity(intent);
            }
        });


        //Handle button Photos---------------------------------
        Photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Photos.class);
                startActivity(intent);
            }
        });
    }
}