package com.example.front_end;


import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.front_end.dictionary.Words;
import com.example.front_end.objects.*;
import com.example.front_end.dictionary.ParsedRequest;
import com.example.front_end.utilities.Parser;
import com.example.front_end.utilities.Service;
import com.example.front_end.utilities.UtilityClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> list = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exit, top, search;
        EditText editText;



       exit = findViewById(R.id.button_exit);
       top = findViewById(R.id.button_top_cities);
       search = findViewById(R.id.button_search);
       editText = findViewById(R.id.editText_findCity);

       String city = getIntent().getStringExtra("city");
       String place = getIntent().getStringExtra("place");
       String nearby = getIntent().getStringExtra("nearby");
       String activity = getIntent().getStringExtra("activity");

       if(city != null){
           list = setTheList(city, place, nearby, activity);
           city = "";
           place = "";
           nearby = "";
           activity = "";
           setContentView(R.layout.loading);
           list = listToLower(list);
           city = null;
           String halfUrl = connectUrl(list);
           Parser parser = new Parser();
           ParsedRequest parsedRequest = parser.runParser(list);
           recoverTheDataToSend(parsedRequest, halfUrl, getActivityString(list));

       }

       exit.setOnClickListener(v -> {
          finish();
          System.exit(0);
        });

       top.setOnClickListener(v -> {
           Service service = new Service();
           service.getJSONArray(this, "topCities", new Service.VolleyResponseListener() {
               @Override
               public void onResponse(JSONObject jsonObject) {

               }

               @Override
               public void onResponse(JSONArray jsonArray) {
                    UtilityClass.getInstance().setList(setJsonOnArrayList(jsonArray, Words.TOWN));
                    openActivity("townsactivity");
               }

               @Override
               public void onError(String message) {
                   Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
               }
           });
       });

       search.setOnClickListener(v -> {
           Service service = new Service();
                   service.getJSONObject(this, editText.getText().toString(), new Service.VolleyResponseListener() {
               @Override
               public void onResponse(JSONObject jsonObject) {
                   UtilityClass.getInstance().setList(setJsonObject(jsonObject, Words.TOWN));
                   openActivity("information");
               }

               @Override
               public void onResponse(JSONArray jsonArray) {

               }

               @Override
               public void onError(String message) {
                   Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
               }
           });
       });
    }

    private String getActivityString(ArrayList<String> list) {
        int size = list.size();
        return list.get(size-1);
    }

    private void recoverTheDataToSend(ParsedRequest parsedRequest, String halfUrl, String activity) {
        findTheJsonToSend(parsedRequest, halfUrl, activity);
    }

    private ArrayList<String> setTheList(String city, String place, String nearby, String activity) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(0, toLower(city));
        if(place != null){
            arrayList.add(1, toLower(place));
        }
        if(nearby != null){
            arrayList.add(2, toLower(nearby));
        }
        if(activity != null){
            arrayList.add(3, toLower(activity));
        }
        return arrayList;
    }

    private void findTheJsonToSend(ParsedRequest parse, String halfUrl, String activity) {
        switch (parse.getWordType().getWords()){
            case ARRAYLIST:
                sendJsonArrayRequest(parse.getWords(), halfUrl, activity);
            case HOSPITAL:
            case TOWN:
            case COFFEESHOP:
            case SIGHT:
                sendJsonObjectRequest(parse.getWords(), halfUrl, activity);
        }

    }

    private void sendJsonObjectRequest(Words words, String halfUrl, String activity) {
        Service service = new Service();
        switch (words){
            case SENDTOWN:
                service.getJSONObject(this, halfUrl, new Service.VolleyResponseListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        UtilityClass.getInstance().setList(setJsonObject(jsonObject, Words.TOWN));
                        openActivity(activity);
                    }

                    @Override
                    public void onResponse(JSONArray jsonArray) {

                    }

                    @Override
                    public void onError(String message) {
                        showErrorMessage(message, activity);
                    }
                });
                break;
            case SENDSIGHT:
                service.getJSONObject(this, halfUrl, new Service.VolleyResponseListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        UtilityClass.getInstance().setList(setJsonObject(jsonObject, Words.SIGHT));
                        openActivity(activity);
                    }

                    @Override
                    public void onResponse(JSONArray jsonArray) {

                    }

                    @Override
                    public void onError(String message) {
                        showErrorMessage(message, activity);
                    }
                });
                break;
            case SENDHOSPITAL:
                service.getJSONObject(this, halfUrl, new Service.VolleyResponseListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        UtilityClass.getInstance().setList(setJsonObject(jsonObject, Words.HOSPITAL));
                        openActivity(activity);
                    }

                    @Override
                    public void onResponse(JSONArray jsonArray) {

                    }

                    @Override
                    public void onError(String message) {
                        showErrorMessage(message, activity);
                    }
                });
                break;
            case SENDCOFFEESHOP:
                service.getJSONObject(this, halfUrl, new Service.VolleyResponseListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        UtilityClass.getInstance().setList(setJsonObject(jsonObject, Words.COFFEESHOP));
                        openActivity(activity);
                    }

                    @Override
                    public void onResponse(JSONArray jsonArray) {

                    }

                    @Override
                    public void onError(String message) {
                        showErrorMessage(message, activity);
                    }
                });
        }
    }

    private void showErrorMessage(String message, String activity) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        openActivity(activity);
    }

    private void sendJsonArrayRequest(Words words, String halfUrl, String activity) {
        Service service = new Service();
        switch (words){
            case SENDTOWN:
                service.getJSONArray(this, halfUrl, new Service.VolleyResponseListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                    }

                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        UtilityClass.getInstance().setList(setJsonOnArrayList(jsonArray, Words.TOWN));
                        openActivity(activity);
                    }

                    @Override
                    public void onError(String message) {
                        showErrorMessage(message, activity);
                    }
                });
                break;
            case SENDSIGHT:
                service.getJSONArray(this, halfUrl, new Service.VolleyResponseListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                    }

                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        UtilityClass.getInstance().setList(setJsonOnArrayList(jsonArray, Words.SIGHT));
                        openActivity(activity);
                    }

                    @Override
                    public void onError(String message) {
                        showErrorMessage(message, activity);
                    }
                });
                break;
            case SENDCOFFEESHOP:
                service.getJSONArray(this, halfUrl, new Service.VolleyResponseListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                    }

                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        UtilityClass.getInstance().setList(setJsonOnArrayList(jsonArray, Words.COFFEESHOP));
                        openActivity(activity);
                    }

                    @Override
                    public void onError(String message) {
                        showErrorMessage(message, activity);
                    }
                });
                break;
            case SENDHOSPITAL:
                service.getJSONArray(this, halfUrl, new Service.VolleyResponseListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                    }

                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        UtilityClass.getInstance().setList(setJsonOnArrayList(jsonArray, Words.HOSPITAL));
                        openActivity(activity);
                    }

                    @Override
                    public void onError(String message) {
                        showErrorMessage(message, activity);
                    }
                });
                break;
        }
    }

    private ArrayList setJsonObject(JSONObject object, Words words){
        Gson gson = new Gson();
        ArrayList arrayList = new ArrayList<>();
        switch(words){
            case TOWN:
                arrayList.add(gson.fromJson(String.valueOf(object), Town.class));
                break;
            case SIGHT:
                arrayList.add(gson.fromJson(String.valueOf(object), Sight.class));
                break;
            case HOSPITAL:
                arrayList.add(gson.fromJson(String.valueOf(object), Hospital.class));
                break;
            case COFFEESHOP:
                arrayList.add(gson.fromJson(String.valueOf(object), CoffeeShop.class));
                break;
        }
        throw new IllegalStateException("Unexpected value: " + words);
    }

    private ArrayList setJsonOnArrayList(JSONArray json, Words word){
        Gson gson = new Gson();
        ArrayList arrayList;
        switch(word){
            case TOWN:
                arrayList = gson.fromJson(String.valueOf(json), new TypeToken<ArrayList<Town>>(){}.getType());
                break;
            case HOSPITAL:
                arrayList = gson.fromJson(String.valueOf(json), new TypeToken<ArrayList<Hospital>>(){}.getType());
                break;
            case SIGHT:
                arrayList = gson.fromJson(String.valueOf(json), new TypeToken<ArrayList<Sight>>(){}.getType());
                break;
            case COFFEESHOP:
                arrayList = gson.fromJson(String.valueOf(json), new TypeToken<ArrayList<CoffeeShop>>(){}.getType());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + word);
        }
        return arrayList;
    }

    private void openActivity(String activity) {
        switch (activity){
            case "information":
                Intent intent = new Intent(this, Information.class);
                startActivity(intent);
                break;
            case "display":
                Intent intent1 = new Intent(this, Display.class);
                startActivity(intent1);
                break;
            case "topfive":
                Intent intent2 = new Intent(this, TopFive.class);
                startActivity(intent2);
                break;
            case "townsactivity":
                Intent intent3 = new Intent(this, TownsActivity.class);
                startActivity(intent3);
                break;
            case "photos":
                Intent intent4 = new Intent(this, Photos.class);
                startActivity(intent4);
                break;
        }
    }

    private static ArrayList listToLower(ArrayList<String> arrayList){
        ArrayList<String> array = new ArrayList<>();
        String str = "";
        for(String string : arrayList){
            str = toLower(string);
            array.add(str);
        }
        return array;
    }

    private static String toLower(String input) {
        String lower = "";
        String delims = "[ \t,.:;?!\"']+";
        if(input != null) {
            lower = String.valueOf(input.split(delims));
            lower = input.trim().toLowerCase();
        }
        return lower;
    }

    private String connectUrl(ArrayList<String> arrayList){
        String newUrl = null;
        for(int i = 0; i < arrayList.size(); i++){
            newUrl = newUrl + "/"+arrayList.get(i);
        }
        return newUrl;
    }



}