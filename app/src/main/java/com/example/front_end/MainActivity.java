package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------------TESTING ACTIVITIES---------------------
        Intent New=new Intent(getApplicationContext(),TownsActivity.class);
        startActivity(New);
        //


       Button exit;


       exit = findViewById(R.id.button_exit);

       exit.setOnClickListener(v -> {
          finish();
          System.exit(0);
        });
    }
}