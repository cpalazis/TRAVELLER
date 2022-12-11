package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //start the code from here
        setTitle("Display Activity");

        //create the get Intent object
        //Intent intent = getIntent();

        //receive the value by getStringExtra() method and
        //key must be same which is send by first activity
        //String str = intent.getStringExtra("message_key"); //receive string
        //Place place = (Place) intent.getSerializableExtra("sampleObject"); //receive object


        TextView infoTxt = findViewById(R.id.PlaceInfoTxtView);
        ImageView img = findViewById(R.id.imageViewP1);
        TextView descriptionTxt = findViewById(R.id.descriptionTextView);

        //---------------------------START DATA FOR TESTING----------------------------------
        String str = "name of place" + " ******";
        String url = "https://upload.wikimedia.org/wikipedia/commons/4/49/Corfu_Vlacherna_R01.jpg";
        String textInfo = "xxxxxxxx"+"yyyyyyyy"+"********"+"ooooooooo";

        //display the name of place into TextView
        infoTxt.setText("Informations for place: "+str);

        //infoTxt.setText("Informations for place: "+place.getNameP());
        // OR display the string into TextView from object

        //Show the Place image
        Picasso.with(this).load(url).resize(600,300).into(img);
        //Picasso.get().load(url).resize(600,300).into(img);


        //Show the Place description
        descriptionTxt.setText(textInfo);
        //create scroll
        descriptionTxt.setMovementMethod(new ScrollingMovementMethod());



    }
}