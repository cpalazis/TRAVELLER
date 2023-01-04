package com.example.front_end;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.front_end.objects.CoffeeShop;
import com.example.front_end.objects.Sight;
import com.example.front_end.objects.Town;
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
        Button map = findViewById(R.id.mapButton);

        //get index selection from TopFive activity, one from five
        Intent intent = getIntent();
        String index= intent.getStringExtra("index");
        int idx= Integer.parseInt(index);  //convert string to int


        ArrayList<Town> town = UtilityClass.getInstance().getTownList();
        ArrayList<Museum> museum = UtilityClass.getInstance().getMuseumList();
        ArrayList<Hotel> hotel = UtilityClass.getInstance().getHotelList();
        ArrayList<Bank> bank = UtilityClass.getInstance().getBankList();
        ArrayList<CoffeeShop> caffe = UtilityClass.getInstance().getCoffeeShopList();
        ArrayList<Restaurant> restaurant = UtilityClass.getInstance().getRestaurantList();
        ArrayList<Sight> sight = UtilityClass.getInstance().getSightList();

        //Display for City
        if (town != null){
            infoTxt.setText("Informations for City: " + town.get(0).getName()); //name city
            Picasso.with(this).load(town.get(0).getImages().get(0)).resize(600,300).into(img); //city image url
            descriptionTxt.setText(town.get(0).getExcerpt()); // description of the city

        }

        //Display for Museums
        else if (museum != null){
            infoTxt.setText("Informations for Museum: " + museum.get(idx).getName()); //name museum
            Picasso.with(this).load(museum.get(idx).getImages().get(0)).resize(600,300).into(img); //museum image url
            descriptionTxt.setText(museum.get(idx).getExcerpt()); // description of the museum

        }

        //Display for Hotels
        else if (hotel != null){
            infoTxt.setText("Informations for Hotel: " + hotel.get(idx).getName()); //hotel city
            Picasso.with(this).load(hotel.get(idx).getImages().get(0)).resize(600,300).into(img); //hotel image url
            descriptionTxt.setText(hotel.get(idx).getExcerpt()); // description of the hotel

        }

        //Display for Banks
        else if (bank != null){
            infoTxt.setText("Informations for Bank: " + bank.get(idx).getName()); //name bank
            Picasso.with(this).load(bank.get(idx).getImages().get(0)).resize(600,300).into(img); //bank image url
            descriptionTxt.setText(bank.get(idx).getExcerpt()); // description of the bank

        }

        //Display for Caffe
        else if (caffe != null){
            infoTxt.setText("Informations for Caffe: " + caffe.get(idx).getName()); //name caffe
            Picasso.with(this).load(caffe.get(idx).getImages().get(0)).resize(600,300).into(img); //caffe image url
            descriptionTxt.setText(town.get(idx).getExcerpt()); // description of the caffe

        }

        //Display for Restaurants
        else if (restaurant != null){
            infoTxt.setText("Informations for Restaurant: " + restaurant.get(idx).getName()); //name restaurant
            Picasso.with(this).load(restaurant.get(idx).getImages().get(0)).resize(600,300).into(img); //restaurant image url
            descriptionTxt.setText(restaurant.get(idx).getExcerpt()); // description of the restaurant

        }

        //Display for Sights


        else if (sight != null){
            infoTxt.setText("Informations for Sight: " + sight.get(idx).getName()); //name sight
            Picasso.with(this).load(sight.get(idx).getImages().get(0)).resize(600,300).into(img); //sight image url
            descriptionTxt.setText(sight.get(idx).getExcerpt()); // description of the sight

        }


        //DISPLAY MAP
        descriptionTxt.setMovementMethod(new ScrollingMovementMethod());

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MapActivity.class);
                startActivity(intent);
            }
        });

    }

}