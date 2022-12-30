package com.example.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.front_end.utilities.UtilityClass;

import java.util.ArrayList;

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


        ArrayList<String> cities = new ArrayList<>();
        cities= UtilityClass.getInstance().getList();

        if (cities != null){
            infoTxt.setText(cities.get(0));
        }



        //Handle button Museums---------------------------------
        Museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                intent.putExtra("place","Museums");  //the name of place
                intent.putExtra("activity","TopFive"); //Put data in TopFive Activity for top 5 museums
                startActivity(intent);

            }
        });

        //Handle button Hotels---------------------------------
        Hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                intent.putExtra("place","Hotels");  //the name of place
                intent.putExtra("activity","TopFive");  //Put data in TopFive Activity for top 5 hotels
                startActivity(intent);

            }
        });

        //Handle button Banks---------------------------------
        Banks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                intent.putExtra("place","Banks");  //the name of place
                intent.putExtra("activity","TopFive");    //Put data in TopFive Activity for top 5 banks
                startActivity(intent);

            }
        });

        //Handle button Caffe---------------------------------
        Caffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                intent.putExtra("place","Caffe");  //the name of place
                intent.putExtra("activity","TopFive"); //Put data in TopFive Activity for top 5 caffe
                startActivity(intent);

            }
        });

        //Handle button Restaurants---------------------------------
        Restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                intent.putExtra("place","Restaurants");  //the name of place
                intent.putExtra("activity","TopFive"); //Put data in TopFive Activity for top 5 restaurants
                startActivity(intent);

            }
        });

        //Handle button Sights---------------------------------
        Sights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                intent.putExtra("place","Sights");  //the name of place
                intent.putExtra("activity","TopFive"); //Put data in TopFive Activity for top 5 sights
                startActivity(intent);

            }
        });


        //Handle button General_Informations---------------------------------


        General_Informations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                intent.putExtra("place","General_Informations");  //the name of place
                intent.putExtra("activity","Display"); //Put data in Display Activity
                                                                  // Insert general information for the city who looking for
                                                                  //and one famous photo
                startActivity(intent);



            }
        });


        //Handle button Photos---------------------------------

        Photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city",infoTxt.getText().toString()); //the name of city
                intent.putExtra("place","Photos");  //the name of place
                intent.putExtra("activity","Photos"); //Put data in Photos Activity
                                                                 // Insert the 12 famous photos for the city who looking for
                startActivity(intent);


            }
        });
    }
}