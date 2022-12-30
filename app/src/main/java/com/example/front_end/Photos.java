package com.example.front_end;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.front_end.utilities.UtilityClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Photos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        //start the code from here
        setTitle("Photos Activity");

        //---------------------------START DATA FOR TESTING----------------------------------
        //Images from Serres
        //String url1 = "https://www.kastra.eu/pics/serres12.jpg";
        //String url2 = "https://foititisonline.gr/wp-content/uploads/2018/03/koilada-serrwn2.jpg";
        //String url3 = "https://www.ertnews.gr/wp-content/uploads/2020/11/dioikhthrio-e-vima.jpg";
        //Images from Drama
        //String url4 = "https://happytraveller.gr/wp-content/uploads/2018/09/drama-happy-traveller.jpg";
        //String url5 = "https://www.greekgastronomyguide.gr/wp-content/uploads/2016/06/parko-agias-varvaras-drama-DSC_7905.jpg";
        //String url6 = "https://i1.prth.gr/images/1168x656/_webp/files/2020-10-01/oneiroupolh-dramas.jpg";
        //Images from Kavala
        //String url7 = "https://www.kathimerini.gr//resources/2018-03/paralia-kavala-vrady.jpg";
        //String url8 = "https://cdn.cnngreece.gr/media/news/2018/10/09/150003/main/1.jpg";
        //String url9 = "https://www.kathimerini.gr//resources/2015-09/kavala2.jpg";
        //Images from Corfu
        //String url10 = "https://upload.wikimedia.org/wikipedia/commons/4/49/Corfu_Vlacherna_R01.jpg";
        //String url11 = "https://www.filippistours.gr/wp-content/uploads/2020/07/filippis-tours_ekdromi-kerkyra-parga_005-1600x800.jpg";
        //String url12 = "https://townhouseco.co.uk/wp-content/uploads/2020/02/corfu-feat-1200x900.jpg";
        //------------------END DATA FOR TESTING-----------------------------------------------

        String url1 ="";
        String url2 ="";
        String url3 ="";
        String url4 ="";
        String url5 ="";
        String url6 ="";
        String url7 ="";
        String url8 ="";
        String url9 ="";
        String url10 ="";
        String url11 ="";
        String url12 ="";

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

        ArrayList<String> cityPhotos = new ArrayList<>();
        cityPhotos= UtilityClass.getInstance().getList();

        if ( cityPhotos != null){

            CityName.setText("City name: "+ cityPhotos.get(0)); //index 0 = city name

            //Put urls for city photos
            url1 = cityPhotos.get(1); // index 1 until 12 = 12 photos of the city
            url2 = cityPhotos.get(2);
            url3 = cityPhotos.get(3);
            url4 = cityPhotos.get(4);
            url5 = cityPhotos.get(5);
            url6 = cityPhotos.get(6);
            url7 = cityPhotos.get(7);
            url8 = cityPhotos.get(8);
            url9 = cityPhotos.get(9);
            url10 = cityPhotos.get(10);
            url11 = cityPhotos.get(11);
            url12 = cityPhotos.get(12);


        }


        //Picasso.with(this).load(url1).resize(600,300).into(img);
        //Picasso.get().load(url12).resize(200,100).into(imgButton12);
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


        //Show image from buttons, in great scale, when one of them is pushed
        //-----------------------------------
        String finalUrl1 = url1;
        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl1).resize(600,300).into(img);
            }
        });

        //-----------------------------------
        String finalUrl2 = url2;
        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl2).resize(600,300).into(img);
            }
        });

        //------------------------------------
        String finalUrl3 = url3;
        imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl3).resize(600,300).into(img);
            }
        });

        //------------------------------------
        String finalUrl4 = url4;
        imgButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl4).resize(600,300).into(img);
            }
        });

        //------------------------------------
        String finalUrl5 = url5;
        imgButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl5).resize(600,300).into(img);
            }
        });

        //------------------------------------
        String finalUrl6 = url6;
        imgButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl6).resize(600,300).into(img);
            }
        });

        //-----------------------------------
        String finalUrl7 = url7;
        imgButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl7).resize(600,300).into(img);
            }
        });

        //-----------------------------------
        String finalUrl8 = url8;
        imgButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl8).resize(600,300).into(img);
            }
        });

        //-----------------------------------
        String finalUrl9 = url9;
        imgButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl9).resize(600,300).into(img);
            }
        });

        //------------------------------------
        String finalUrl10 = url10;
        imgButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl10).resize(600,300).into(img);
            }
        });

        //------------------------------------
        String finalUrl11 = url11;
        imgButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl11).resize(600,300).into(img);
            }
        });

        //------------------------------------
        String finalUrl12 = url12;
        imgButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Picasso.with(Photos.this).load(finalUrl12).resize(600,300).into(img);
            }
        });

    }
}