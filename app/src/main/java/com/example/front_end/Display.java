package com.example.front_end;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.front_end.utilities.UtilityClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //start the code from here
        setTitle("Display Activity");


        TextView infoTxt = findViewById(R.id.PlaceInfoTxtView);
        ImageView img = findViewById(R.id.imageViewP1);
        TextView descriptionTxt = findViewById(R.id.descriptionTextView);

        ArrayList<String> place = new ArrayList<>();
        place= UtilityClass.getInstance().getList();

        if (place != null){
            infoTxt.setText("Informations for place: " + place.get(0)); //index 0 = place name
            Picasso.with(this).load(place.get(1)).resize(600,300).into(img); //index 1 = image url
            descriptionTxt.setText(place.get(2)); // index 2 = description of the place


        }

        //---------------------------START DATA FOR TESTING----------------------------------
        //String str = "name of place" + " ******";
        //String url = "https://upload.wikimedia.org/wikipedia/commons/4/49/Corfu_Vlacherna_R01.jpg";
        //String textInfo = "xxxxxxxx"+"yyyyyyyy"+"********"+"ooooooooo";
        //------------display the name of place into TextView
        //infoTxt.setText("Informations for place: "+str);
        //infoTxt.setText("Informations for place: "+place.getNameP());
        //---------OR display the string into TextView from object
        //Show the Place image
        //Picasso.with(this).load(url).resize(600,300).into(img);
        //Picasso.get().load(url).resize(600,300).into(img);
        //Show the Place description
        //descriptionTxt.setText(textInfo);


        //create scroll
        descriptionTxt.setMovementMethod(new ScrollingMovementMethod());

    }
}