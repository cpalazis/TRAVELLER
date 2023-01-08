package com.example.front_end;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.front_end.objects.CoffeeShop;
import com.example.front_end.objects.Sight;
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

        ArrayList<Museum> museum = UtilityClass.getInstance().getMuseumList();
        ArrayList<Hotel> hotel = UtilityClass.getInstance().getHotelList();
        ArrayList<Bank> bank = UtilityClass.getInstance().getBankList();
        ArrayList<CoffeeShop> caffe = UtilityClass.getInstance().getCoffeeShopList();
        ArrayList<Restaurant> restaurant = UtilityClass.getInstance().getRestaurantList();
        ArrayList<Sight> sight = UtilityClass.getInstance().getSightList();

       if(museum != null){
            //ArrayList<Museum> places = UtilityClass.getInstance().getMuseumList();

           buttonPlaceName.get(0).setText(museum.get(0).getName());
           buttonPlaceName.get(1).setText(museum.get(1).getName());
           buttonPlaceName.get(2).setText(museum.get(2).getName());
           buttonPlaceName.get(3).setText(museum.get(3).getName());
           buttonPlaceName.get(4).setText(museum.get(4).getName());

           Picasso.with(this).load(museum.get(0).getImages().get(0)).resize(600,300).into(img1);
           Picasso.with(this).load(museum.get(1).getImages().get(0)).resize(600,300).into(img2);
           Picasso.with(this).load(museum.get(2).getImages().get(0)).resize(600,300).into(img3);
           Picasso.with(this).load(museum.get(3).getImages().get(0)).resize(600,300).into(img4);
           Picasso.with(this).load(museum.get(4).getImages().get(0)).resize(600,300).into(img5);
       }
        else if (hotel != null){
            //ArrayList<Hotel> places = UtilityClass.getInstance().getHotelList();

           buttonPlaceName.get(0).setText(hotel.get(0).getName());
           buttonPlaceName.get(1).setText(hotel.get(1).getName());
           buttonPlaceName.get(2).setText(hotel.get(2).getName());
           buttonPlaceName.get(3).setText(hotel.get(3).getName());
           buttonPlaceName.get(4).setText(hotel.get(4).getName());

           Picasso.with(this).load(hotel.get(0).getImages().get(0)).resize(600,300).into(img1);
           Picasso.with(this).load(hotel.get(1).getImages().get(0)).resize(600,300).into(img2);
           Picasso.with(this).load(hotel.get(2).getImages().get(0)).resize(600,300).into(img3);
           Picasso.with(this).load(hotel.get(3).getImages().get(0)).resize(600,300).into(img4);
           Picasso.with(this).load(hotel.get(4).getImages().get(0)).resize(600,300).into(img5);
       }
        else if (bank != null){
            //ArrayList<Bank> places = UtilityClass.getInstance().getBankList();

           buttonPlaceName.get(0).setText(bank.get(0).getName());
           buttonPlaceName.get(1).setText(bank.get(1).getName());
           buttonPlaceName.get(2).setText(bank.get(2).getName());
           buttonPlaceName.get(3).setText(bank.get(3).getName());
           buttonPlaceName.get(4).setText(bank.get(4).getName());

           Picasso.with(this).load(bank.get(0).getImages().get(0)).resize(600,300).into(img1);
           Picasso.with(this).load(bank.get(1).getImages().get(0)).resize(600,300).into(img2);
           Picasso.with(this).load(bank.get(2).getImages().get(0)).resize(600,300).into(img3);
           Picasso.with(this).load(bank.get(3).getImages().get(0)).resize(600,300).into(img4);
           Picasso.with(this).load(bank.get(4).getImages().get(0)).resize(600,300).into(img5);
       }
        else if (caffe != null){
           //ArrayList<CoffeeShop> places = UtilityClass.getInstance().getCoffeeShopList();

           buttonPlaceName.get(0).setText(caffe.get(0).getName());
           buttonPlaceName.get(1).setText(caffe.get(1).getName());
           buttonPlaceName.get(2).setText(caffe.get(2).getName());
           buttonPlaceName.get(3).setText(caffe.get(3).getName());
           buttonPlaceName.get(4).setText(caffe.get(4).getName());

           Picasso.with(this).load(caffe.get(0).getImages().get(0)).resize(600,300).into(img1);
           Picasso.with(this).load(caffe.get(1).getImages().get(0)).resize(600,300).into(img2);
           Picasso.with(this).load(caffe.get(2).getImages().get(0)).resize(600,300).into(img3);
           Picasso.with(this).load(caffe.get(3).getImages().get(0)).resize(600,300).into(img4);
           Picasso.with(this).load(caffe.get(4).getImages().get(0)).resize(600,300).into(img5);
       }
        else if (restaurant !=null){
           //ArrayList<Restaurant> places = UtilityClass.getInstance().getRestaurantList();

           buttonPlaceName.get(0).setText(restaurant.get(0).getName());
           buttonPlaceName.get(1).setText(restaurant.get(1).getName());
           buttonPlaceName.get(2).setText(restaurant.get(2).getName());
           buttonPlaceName.get(3).setText(restaurant.get(3).getName());
           buttonPlaceName.get(4).setText(restaurant.get(4).getName());

           Picasso.with(this).load(restaurant.get(0).getImages().get(0)).resize(600,300).into(img1);
           Picasso.with(this).load(restaurant.get(1).getImages().get(0)).resize(600,300).into(img2);
           Picasso.with(this).load(restaurant.get(2).getImages().get(0)).resize(600,300).into(img3);
           Picasso.with(this).load(restaurant.get(3).getImages().get(0)).resize(600,300).into(img4);
           Picasso.with(this).load(restaurant.get(4).getImages().get(0)).resize(600,300).into(img5);

       }
        else if (sight !=null){
           //ArrayList<Sight> places = UtilityClass.getInstance().getSightList();

           buttonPlaceName.get(0).setText(sight.get(0).getName());
           buttonPlaceName.get(1).setText(sight.get(1).getName());
           buttonPlaceName.get(2).setText(sight.get(2).getName());
           buttonPlaceName.get(3).setText(sight.get(3).getName());
           buttonPlaceName.get(4).setText(sight.get(4).getName());

           Picasso.with(this).load(sight.get(0).getImages().get(0)).resize(600,300).into(img1);
           Picasso.with(this).load(sight.get(1).getImages().get(0)).resize(600,300).into(img2);
           Picasso.with(this).load(sight.get(2).getImages().get(0)).resize(600,300).into(img3);
           Picasso.with(this).load(sight.get(3).getImages().get(0)).resize(600,300).into(img4);
           Picasso.with(this).load(sight.get(4).getImages().get(0)).resize(600,300).into(img5);
       }

/*
        buttonPlaceName.get(0).setText(places.get(0).getName());
        buttonPlaceName.get(1).setText(places.get(1).getName());
        buttonPlaceName.get(2).setText(places.get(2).getName());
        buttonPlaceName.get(3).setText(places.get(3).getName());
        buttonPlaceName.get(4).setText(places.get(4).getName());

        Picasso.with(this).load(places.get(0).getImages().get(0)).resize(600,300).into(img1);
        Picasso.with(this).load(places.get(1).getImages().get(0)).resize(600,300).into(img2);
        Picasso.with(this).load(places.get(2).getImages().get(0)).resize(600,300).into(img3);
        Picasso.with(this).load(places.get(3).getImages().get(0)).resize(600,300).into(img4);
        Picasso.with(this).load(places.get(4).getImages().get(0)).resize(600,300).into(img5);
*/



        buttonPlaceName.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Display.class);
                intent.putExtra("index", "0");
                startActivity(intent);
            }
        });


        buttonPlaceName.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Display.class);
                intent.putExtra("index", "1");
                startActivity(intent);
            }
        });


        buttonPlaceName.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Display.class);
                intent.putExtra("index", "2");
                startActivity(intent);
            }
        });


        buttonPlaceName.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Display.class);
                intent.putExtra("index", "3");
                startActivity(intent);
            }
        });


        buttonPlaceName.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Display.class);
                intent.putExtra("index", "4");
                startActivity(intent);
            }
        });

    }
}