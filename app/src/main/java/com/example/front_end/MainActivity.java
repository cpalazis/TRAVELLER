package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button idButtonTown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idButtonTown = findViewById(R.id.buttonTowns);
        idButtonTown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent topTowns = new Intent(getApplicationContext(),TownsActivity.class);
                startActivity(topTowns);

            }
        });
    }
}