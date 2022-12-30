package com.example.front_end;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.front_end.utilities.UtilityClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TopFive extends AppCompatActivity {
    private List<Button> buttonPlaceName = new ArrayList<>();



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

        ImageView img1 = findViewById(R.id.image1);
        ImageView img2 = findViewById(R.id.image2);
        ImageView img3 = findViewById(R.id.image3);
        ImageView img4 = findViewById(R.id.image4);
        ImageView img5 = findViewById(R.id.image5);

        ArrayList<String> places = new ArrayList<>();
        places= UtilityClass.getInstance().getList();

        if (places != null){
            buttonPlaceName.get(0).setText(places.get(1)); //index 0 = city name
            buttonPlaceName.get(1).setText(places.get(2));
            buttonPlaceName.get(2).setText(places.get(3));
            buttonPlaceName.get(3).setText(places.get(4));
            buttonPlaceName.get(4).setText(places.get(5));

            Picasso.with(this).load(places.get(6)).resize(600,300).into(img1); //index 6 until 10 = image url
            Picasso.with(this).load(places.get(7)).resize(600,300).into(img2);
            Picasso.with(this).load(places.get(8)).resize(600,300).into(img3);
            Picasso.with(this).load(places.get(9)).resize(600,300).into(img4);
            Picasso.with(this).load(places.get(10)).resize(600,300).into(img5);

        }


        ArrayList<String> finalPlaces = places;
        buttonPlaceName.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city", finalPlaces.get(0)); //the name of city
                intent.putExtra("place",buttonPlaceName.get(0).getText().toString());  //the name of place
                intent.putExtra("activity","Display"); //Put data in Display Activity for 1st place
                startActivity(intent);
            }
        });


        buttonPlaceName.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city", finalPlaces.get(0)); //the name of city
                intent.putExtra("place",buttonPlaceName.get(1).getText().toString());  //the name of place
                intent.putExtra("activity","Display"); //Put data in Display Activity for 2nd place
                startActivity(intent);
            }
        });


        buttonPlaceName.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city", finalPlaces.get(0)); //the name of city
                intent.putExtra("place",buttonPlaceName.get(2).getText().toString());  //the name of place
                intent.putExtra("activity","Display"); //Put data in Display Activity for 3rd place
                startActivity(intent);
            }
        });


        buttonPlaceName.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city", finalPlaces.get(0)); //the name of city
                intent.putExtra("place",buttonPlaceName.get(3).getText().toString());  //the name of place
                intent.putExtra("activity","Display"); //Put data in Display Activity for 4th place
                startActivity(intent);
            }
        });


        buttonPlaceName.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city", finalPlaces.get(0)); //the name of city
                intent.putExtra("place",buttonPlaceName.get(4).getText().toString());  //the name of place
                intent.putExtra("activity","Display"); //Put data in Display Activity for 5th place
                startActivity(intent);
            }
        });

    }
}