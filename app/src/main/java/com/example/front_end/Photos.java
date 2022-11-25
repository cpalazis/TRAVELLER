package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class Photos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        //start the code from here
        setTitle("Photos Activity");

        //---------------------------START DATA FOR TESTING----------------------------------
        //Images from Serres
        String url1 = "https://www.kastra.eu/pics/serres12.jpg";
        String url2 = "https://foititisonline.gr/wp-content/uploads/2018/03/koilada-serrwn2.jpg";
        String url3 = "https://www.ertnews.gr/wp-content/uploads/2020/11/dioikhthrio-e-vima.jpg";

        //Images from Drama
        String url4 = "https://happytraveller.gr/wp-content/uploads/2018/09/drama-happy-traveller.jpg";
        String url5 = "https://www.greekgastronomyguide.gr/wp-content/uploads/2016/06/parko-agias-varvaras-drama-DSC_7905.jpg";
        String url6 = "https://i1.prth.gr/images/1168x656/_webp/files/2020-10-01/oneiroupolh-dramas.jpg";

        //Images from Kavala
        String url7 = "https://www.kathimerini.gr//resources/2018-03/paralia-kavala-vrady.jpg";
        String url8 = "https://cdn.cnngreece.gr/media/news/2018/10/09/150003/main/1.jpg";
        String url9 = "https://www.kathimerini.gr//resources/2015-09/kavala2.jpg";

        //Images from Corfu
        String url10 = "https://upload.wikimedia.org/wikipedia/commons/4/49/Corfu_Vlacherna_R01.jpg";
        String url11 = "https://www.filippistours.gr/wp-content/uploads/2020/07/filippis-tours_ekdromi-kerkyra-parga_005-1600x800.jpg";
        String url12 = "https://townhouseco.co.uk/wp-content/uploads/2020/02/corfu-feat-1200x900.jpg";

        String city = "City xxxxxx";

        //------------------END DATA FOR TESTING-----------------------------------------------

        TextView CityName = findViewById(R.id.textView);
        ImageView img = findViewById(R.id.imageView);
        ImageButton imgButton1 = findViewById(R.id.imageButton);
        ImageButton imgButton2 = findViewById(R.id.imageButton2);
        ImageButton imgButton3 = findViewById(R.id.imageButton3);
        ImageButton imgButton4 = findViewById(R.id.imageButton4);
        ImageButton imgButton5 = findViewById(R.id.imageButton5);
        ImageButton imgButton6 = findViewById(R.id.imageButton6);
        ImageButton imgButton7 = findViewById(R.id.imageButton7);
        ImageButton imgButton8 = findViewById(R.id.imageButton8);
        ImageButton imgButton9 = findViewById(R.id.imageButton9);
        ImageButton imgButton10 = findViewById(R.id.imageButton10);
        ImageButton imgButton11 = findViewById(R.id.imageButton11);
        ImageButton imgButton12 = findViewById(R.id.imageButton12);


        CityName.setText("City name: "+"*******");
        //Picasso.with(this).load(url1).resize(600,300).into(img);
        Picasso.with(this).load(url1).resize(200,100).into(imgButton1);
        Picasso.with(this).load(url2).resize(200,100).into(imgButton2);
        Picasso.with(this).load(url3).resize(200,100).into(imgButton3);
        Picasso.with(this).load(url4).resize(200,100).into(imgButton4);
        Picasso.with(this).load(url5).resize(200,100).into(imgButton5);
        Picasso.with(this).load(url6).resize(200,100).into(imgButton6);
        Picasso.with(this).load(url7).resize(200,100).into(imgButton7);
        Picasso.with(this).load(url8).resize(200,100).into(imgButton8);
        Picasso.with(this).load(url9).resize(200,100).into(imgButton9);
        Picasso.with(this).load(url10).resize(200,100).into(imgButton10);
        Picasso.with(this).load(url11).resize(200,100).into(imgButton11);
        Picasso.with(this).load(url12).resize(200,100).into(imgButton12);


        //-----------------------------------
        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(getApplicationContext()).load(url1).resize(600,300).into(img);
            }
        });

        //-----------------------------------
        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(getApplicationContext()).load(url2).resize(600,300).into(img);
            }
        });

        //------------------------------------
        imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(Photos.this).load(url3).resize(600,300).into(img);
            }
        });

        //------------------------------------
        imgButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(Photos.this).load(url4).resize(600,300).into(img);
            }
        });

        //------------------------------------
        imgButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(Photos.this).load(url5).resize(600,300).into(img);
            }
        });

        //------------------------------------
        imgButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(Photos.this).load(url6).resize(600,300).into(img);
            }
        });

        //-----------------------------------
        imgButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(getApplicationContext()).load(url7).resize(600,300).into(img);
            }
        });

        //-----------------------------------
        imgButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(getApplicationContext()).load(url8).resize(600,300).into(img);
            }
        });

        //-----------------------------------
        imgButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(getApplicationContext()).load(url9).resize(600,300).into(img);
            }
        });

        //------------------------------------
        imgButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(Photos.this).load(url10).resize(600,300).into(img);
            }
        });

        //------------------------------------
        imgButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(Photos.this).load(url11).resize(600,300).into(img);
            }
        });

        //------------------------------------
        imgButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityName.setText("City name: "+city);
                Picasso.with(Photos.this).load(url12).resize(600,300).into(img);
            }
        });

    }
}