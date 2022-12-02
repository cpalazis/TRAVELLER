package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TokyoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tokyo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}