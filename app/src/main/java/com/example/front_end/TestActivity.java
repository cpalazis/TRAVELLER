package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.front_end.dictionary.Words;
import com.example.front_end.objects.Foo;
import com.example.front_end.utilities.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        Button send, clear;
        ArrayList<TextView> names = new ArrayList<>();
        ArrayList<TextView> cities = new ArrayList<>();

        send = findViewById(R.id.button_send_request);
        clear = findViewById(R.id.button_clear);
        cities.add(0, findViewById(R.id.textView_1));
        cities.add(1, findViewById(R.id.textView_2));
        cities.add(2, findViewById(R.id.textView_3));
        cities.add(3, findViewById(R.id.textView_4));
        names.add(0, findViewById(R.id.textView_5));
        names.add(1, findViewById(R.id.textView_6));
        names.add(2, findViewById(R.id.textView_7));
        names.add(3, findViewById(R.id.textView_8));

        ArrayList<Foo> fools = UtilityClass.getInstance().getFools();

        if(fools != null){
            int i = 0;
            for(Foo foo : fools){
                cities.get(i).setText(foo.getCity());
                names.get(i).setText(foo.getName());
                i++;
            }
        }

        send.setOnClickListener(v -> {

            HashMap<String, Words> map = new HashMap();
            map.put("town", Words.SENDARRAYFOO);
            map.put("TestActivity", Words.ACTIVITY);
            UtilityClass.getInstance().setMapList(map);
            openActivity();
        });

        clear.setOnClickListener(v -> {
            for(int i = 0; i < cities.size(); i++){
                cities.get(i).setText("");
                names.get(i).setText("");
            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}