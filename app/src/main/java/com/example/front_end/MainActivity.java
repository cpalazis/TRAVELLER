package com.example.front_end;


import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.front_end.dictionary.WordType;
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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


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

        HashMap<String, Words> map = UtilityClass.getInstance().getMapList();

        if (map != null) {
            Parser parser = new Parser();
            ParsedRequest parsedRequest = parser.runParser(map);
            Response response = findTheObjectToSend(parsedRequest);
            response.send();
        }

        exit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        top.setOnClickListener(v -> {
            SendTown topTowns = new SendTown("topCities", Words.SENDARRAYTOWN, "TownsActivity");
        });
        search.setOnClickListener(v -> {
            if(editText.getText().toString() != null) {
                SendTown town = new SendTown(editText.getText().toString(), Words.SENDTOWN, "Information");
            }
        });


    }

    private Response findTheObjectToSend(ParsedRequest parsedRequest) {
        switch (parsedRequest.getTypeArrayList().get(0).getWords()){
            case SENDTOWN:
            case SENDARRAYTOWN:
                return new SendTown(setTheHalfUrl(parsedRequest.getTypeArrayList()),
                        parsedRequest.getTypeArrayList().get(0).getWords(),findActivity(parsedRequest.getTypeArrayList()));
            case SENDSIGHT:
            case SENDARRAYSIGHT:
                return new SendSight(setTheHalfUrl(parsedRequest.getTypeArrayList()),
                        parsedRequest.getTypeArrayList().get(0).getWords(), findActivity(parsedRequest.getTypeArrayList()));
            case SENDHOSPITAL:
            case SENDARRAYHOSPITAL:
                return new SendHospital(setTheHalfUrl(parsedRequest.getTypeArrayList()),
                        parsedRequest.getTypeArrayList().get(0).getWords(), findActivity(parsedRequest.getTypeArrayList()));
            case SENDCOFFEESHOP:
            case SENDARRAYCOFFEESHOP:
                return new SendCoffeeShop(setTheHalfUrl(parsedRequest.getTypeArrayList()),
                        parsedRequest.getTypeArrayList().get(0).getWords(), findActivity(parsedRequest.getTypeArrayList()));

        }
        throw new IllegalStateException();
    }

    private interface Response {
        void send();
    }

    private class SendTown implements Response {
        private String name;
        private Words words;
        private String activity;

        public SendTown(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {
            switch (words){
                case SENDTOWN:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setTownList(setJsonObjectToTownList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            openActivity(activity);
                        }
                    });
                    break;

                case SENDARRAYTOWN:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setTownList(setJsonArrayToTownList(jsonArray));
                            openActivity(activity);
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            openActivity(activity);

                        }
                    });
                    break;
            }

        }
        private ArrayList<Town> setJsonObjectToTownList(JSONObject jsonObject){
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) Town.class);

        }
        private ArrayList<Town> setJsonArrayToTownList(JSONArray jsonArray){
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray),  new TypeToken<ArrayList<Town>>(){}.getType());
        }
    }

    private class SendSight implements Response {
        private String name;
        private Words words;
        private String activity;

        public SendSight(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {
            switch (words){
                case SENDSIGHT:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setSightList(setJsonObjectToSightList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            openActivity(activity);
                        }
                    });
                    break;

                case SENDARRAYSIGHT:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setSightList(setJsonArrayToSightList(jsonArray));
                            openActivity(activity);
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            openActivity(activity);
                        }
                    });
                    break;
            }
        }

        private ArrayList<Sight> setJsonArrayToSightList(JSONArray jsonArray) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Sight>>(){}.getType());
        }

        private ArrayList<Sight> setJsonObjectToSightList(JSONObject jsonObject) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) Sight.class);
        }
    }

    private class SendCoffeeShop implements Response {
        private String name;
        private Words words;
        private String activity;

        public SendCoffeeShop(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {
            switch (words){
                case SENDCOFFEESHOP:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setCoffeeShopList(setJsonObjectToCoffeeShopList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            openActivity(activity);
                        }
                    });
                    break;

                case SENDARRAYCOFFEESHOP:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setCoffeeShopList(setJsonArrayToCoffeeShopList(jsonArray));
                            openActivity(activity);
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            openActivity(activity);
                        }
                    });
                    break;
            }

        }

        private ArrayList<CoffeeShop> setJsonArrayToCoffeeShopList(JSONArray jsonArray) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray),  new TypeToken<ArrayList<CoffeeShop>>(){}.getType());
        }

        private ArrayList<CoffeeShop> setJsonObjectToCoffeeShopList(JSONObject jsonObject) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) CoffeeShop.class);
        }
    }

    private class SendHospital implements Response {
        private String name;
        private Words words;
        private String activity;

        public SendHospital(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {
            switch (words){
                case SENDHOSPITAL:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setHospitalList(setJsonObjetToHospitalList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            openActivity(activity);
                        }
                    });
                    break;
                case SENDARRAYHOSPITAL:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setHospitalList(setJsonArrayToHospitalList(jsonArray));
                            openActivity(activity);
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            openActivity(activity);
                        }
                    });
                    break;
            }

        }

        private ArrayList<Hospital> setJsonArrayToHospitalList(JSONArray jsonArray) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Hospital>>(){}.getType());
        }

        private ArrayList<Hospital> setJsonObjetToHospitalList(JSONObject jsonObject) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) Hospital.class);
        }
    }

    private String findActivity(ArrayList<WordType> list) {
        String activity = "";
        for(WordType type : list){
            if(type.getWords().equals(Words.ACTIVITY)){
                activity = type.getPlace();
            }
        }
        return activity;
    }

    private void openActivity(String activity) {
        switch (activity){
            case "Information":
            case "information":
                Intent intent = new Intent(this, Information.class);
                startActivity(intent);
                break;
            case "Photos":
            case "photos":
                Intent intent1 = new Intent(this, Photos.class);
                startActivity(intent1);
                break;
            case "TopFive":
            case "topFive":
            case "topfive":
                Intent intent2 = new Intent(this, TopFive.class);
                startActivity(intent2);
                break;
            case "Display":
            case "display":
                Intent intent3 = new Intent(this, Display.class);
                startActivity(intent3);
                break;
            case "TownsActivity":
            case "townsActivity":
            case "townsactivity":
            case "Townsactivity":
                Intent intent4 = new Intent(this, TownsActivity.class);
                startActivity(intent4);
                break;

        }
    }

    private void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private String setTheHalfUrl(ArrayList<WordType> wordTypes){
        switch (wordTypes.get(0).getWords()){
            case SENDTOWN:
                return setCorrectTownString(wordTypes.get(0).getPlace());
            case SENDSIGHT:
            case SENDCOFFEESHOP:
            case SENDHOSPITAL:
            case SENDARRAYSIGHT:
            case SENDARRAYCOFFEESHOP:
            case SENDARRAYHOSPITAL:
                return findTheCorrectHalfUrl(wordTypes);
            case SENDARRAYTOWN:
                return wordTypes.get(0).getPlace();

        }
        throw new IllegalStateException();
     }

    private String findTheCorrectHalfUrl(ArrayList<WordType> wordTypes) {
        String halfUrl = findTheHalfUrl(wordTypes);
        return halfUrl;
        }


    private String findTheHalfUrl(ArrayList<WordType> wordTypes) {
        switch (wordTypes.get(0).getWords()){
            case SENDARRAYHOSPITAL:
            case SENDARRAYCOFFEESHOP:
            case SENDARRAYSIGHT:
                switch (wordTypes.get(1).getWords()) {
                    case TOWN:
                        return wordTypes.get(0).getPlace()+"/"+wordTypes.get(0).getPlace();
                }
            case SENDCOFFEESHOP:
            case SENDSIGHT:
            case HOSPITAL:
                switch(wordTypes.get(1).getWords()){
                    case SIGHT:
                    case HOSPITAL:
                    case COFFEESHOP:
                        return wordTypes.get(1).getPlace()+"/"+wordTypes.get(0).getPlace();
                }
        }
        throw  new IllegalStateException();
    }

    private String setCorrectTownString(String place) {
        return place.substring(0,1).toUpperCase() + place.substring(1).toLowerCase();
    }


}