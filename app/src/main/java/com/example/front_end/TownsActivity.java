package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;


public class TownsActivity extends AppCompatActivity {

    public TownsActivity() {
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towns);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}