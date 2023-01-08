package com.example.front_end;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.front_end.dictionary.WordType;
import com.example.front_end.dictionary.Words;
import com.example.front_end.objects.*;
import com.example.front_end.utilities.ParsedRequest;
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

        if(map != null){
            setContentView(R.layout.loading);
            Parser parser = new Parser();
            ParsedRequest parsedRequest = parser.processHashMap(map);
            Response response = findTheObjectToSend(parsedRequest);
            response.send();
        }

        exit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        top.setOnClickListener(v -> {
            SendFoo foo = new SendFoo("d4867d8b-b5d5-4a48-a4ab-79131b5809b8", Words.SENDARRAYFOO, "TestActivity");
            foo.send();
            /*SendTown topTowns = new SendTown("topCities", Words.SENDARRAYTOWN, "TownsActivity");
            topTowns.send();*/
        });

        search.setOnClickListener(v -> {
            if(editText.getText().toString().matches("")) {
                Toast.makeText(this, "Please insert the name of the Town you seek", Toast.LENGTH_LONG).show();
            }
            else {
                SendTown town = new SendTown(editText.getText().toString(), Words.SENDTOWN, "Information");
                town.send();

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
            case SENDMUSEUM:
            case SENDARRAYMUSEUM:
                return new SendMuseum(setTheHalfUrl(parsedRequest.getTypeArrayList()),
                        parsedRequest.getTypeArrayList().get(0).getWords(), findActivity(parsedRequest.getTypeArrayList()));
            case SENDBANK:
            case SENDARRAYBANK:
                return new SendBank(setTheHalfUrl(parsedRequest.getTypeArrayList()),
                        parsedRequest.getTypeArrayList().get(0).getWords(), findActivity(parsedRequest.getTypeArrayList()));
            case SENDHOTEL:
            case SENDARRAYHOTEL:
                return  new SendHotel(setTheHalfUrl(parsedRequest.getTypeArrayList()),
                        parsedRequest.getTypeArrayList().get(0).getWords(), findActivity(parsedRequest.getTypeArrayList()));
            case SENDRESTAURANT:
            case SENDARRAYRESTAURANT:
                return  new SendRestaurant(setTheHalfUrl(parsedRequest.getTypeArrayList()),
                        parsedRequest.getTypeArrayList().get(0).getWords(), findActivity(parsedRequest.getTypeArrayList()));
            case SENDARRAYFOO:
                return new SendFoo("d4867d8b-b5d5-4a48-a4ab-79131b5809b8",
                        parsedRequest.getTypeArrayList().get(0).getWords(), findActivity(parsedRequest.getTypeArrayList()));

        }
        throw new IllegalStateException();
    }

    private interface Response {
        void send();
    }

    class SendTown implements Response {
        private final String name;
        private final Words words;
        private final String activity;

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
                            setContentView(R.layout.activity_main);
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
                            setContentView(R.layout.activity_main);

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

    class SendSight implements Response {
        private final String name;
        private final Words words;
        private final String activity;

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
                            setContentView(R.layout.activity_main);
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
                            setContentView(R.layout.activity_main);
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

    class SendCoffeeShop implements Response {
        private final String name;
        private final Words words;
        private final String activity;

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
                            setContentView(R.layout.activity_main);
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
                            setContentView(R.layout.activity_main);
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

    class SendHospital implements Response {
        private final String name;
        private final Words words;
        private final String activity;

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
                            setContentView(R.layout.activity_main);
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
                            setContentView(R.layout.activity_main);
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

    class SendFoo implements Response {
        private final String name;
        private final Words words;
        private final String activity;

        public SendFoo(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {

            switch (words){
                case SENDFOO:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setFools(setJsonObjectToFooList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
                case SENDARRAYFOO:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setFools(setJsonArrayToFooList(jsonArray));
                            openActivity(activity);
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
            }

        }

        private ArrayList<Foo> setJsonArrayToFooList(JSONArray jsonArray) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Foo>>(){}.getType());
        }

        private ArrayList<Foo> setJsonObjectToFooList(JSONObject jsonObject) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) Foo.class);
        }
    }

    class SendMuseum implements Response {
        private final String name;
        private final Words words;
        private final String activity;

        public SendMuseum(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {
            switch (words){
                case SENDMUSEUM:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setMuseums(setJsonToMuseumList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
                case SENDARRAYMUSEUM:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setMuseums(setJsonArrayToMuseumList(jsonArray));
                            openActivity(activity);
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
            }

        }

        private ArrayList<Museum> setJsonArrayToMuseumList(JSONArray jsonArray) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Museum>>(){}.getType());
        }

        private ArrayList<Museum> setJsonToMuseumList(JSONObject jsonObject) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) Museum.class);
        }
    }

    class SendBank implements Response {
        private final String name;
        private final Words words;
        private final String activity;

        public SendBank(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {
            switch (words){
                case SENDBANK:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setBanks(setJsonToBankList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
                case SENDARRAYBANK:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setBanks(setJsonArrayToBankList(jsonArray));
                            openActivity(activity);
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
            }

        }

        private ArrayList<Bank> setJsonArrayToBankList(JSONArray jsonArray) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Bank>>(){}.getType());
        }

        private ArrayList<Bank> setJsonToBankList(JSONObject jsonObject) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) Bank.class);
        }

    }

    class SendHotel implements Response {
        private final String name;
        private final Words words;
        private final String activity;

        public SendHotel(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {
            switch (words){
                case SENDHOTEL:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setHotels(setJsonToHotelList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
                case SENDARRAYHOTEL:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setHotels(setJsonArrayToHotelList(jsonArray));
                            openActivity(activity);
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
            }

        }

        private ArrayList<Hotel> setJsonArrayToHotelList(JSONArray jsonArray) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Hotel>>(){}.getType());
        }

        private ArrayList<Hotel> setJsonToHotelList(JSONObject jsonObject) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) Hotel.class);
        }

    }

    class SendRestaurant implements Response {
        private final String name;
        private final Words words;
        private final String activity;

        public SendRestaurant(String name, Words words, String activity) {
            this.name = name;
            this.words = words;
            this.activity = activity;
        }

        @Override
        public void send() {
            switch (words){
                case SENDRESTAURANT:
                    Service service = new Service();
                    service.getJSONObject(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            UtilityClass.getInstance().setRestaurants(setJsonToRestaurantList(jsonObject));
                            openActivity(activity);
                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {

                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
                case SENDARRAYRESTAURANT:
                    Service service1 = new Service();
                    service1.getJSONArray(MainActivity.this, name, new Service.VolleyResponseListener() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {

                        }

                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            UtilityClass.getInstance().setRestaurants(setJsonArrayToRestaurantList(jsonArray));
                        }

                        @Override
                        public void onError(String message) {
                            showErrorMessage(message);
                            setContentView(R.layout.activity_main);
                        }
                    });
                    break;
            }

        }

        private ArrayList<Restaurant> setJsonArrayToRestaurantList(JSONArray jsonArray) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonArray), new TypeToken<ArrayList<Restaurant>>(){}.getType());
        }

        private ArrayList<Restaurant> setJsonToRestaurantList(JSONObject jsonObject) {
            Gson gson = new Gson();
            return gson.fromJson(String.valueOf(jsonObject), (Type) Restaurant.class);
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
            case "TestActivity":
                Intent testIntent = new Intent(this, TestActivity.class);
                startActivity(testIntent);
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
            case SENDHOTEL:
            case SENDBANK:
            case SENDRESTAURANT:
            case SENDMUSEUM:
            case SENDARRAYSIGHT:
            case SENDARRAYCOFFEESHOP:
            case SENDARRAYHOSPITAL:
            case SENDARRAYBANK:
            case SENDARRAYRESTAURANT:
            case SENDARRAYHOTEL:
            case SENDARRAYMUSEUM:
                return findTheCorrectHalfUrl(wordTypes);
            case SENDARRAYTOWN:
            case SENDARRAYFOO:
                return wordTypes.get(0).getPlace();

        }
        throw new IllegalStateException();
     }

    private String findTheCorrectHalfUrl(ArrayList<WordType> wordTypes) {
        return findTheHalfUrl(wordTypes);
        }

    private String findTheHalfUrl(ArrayList<WordType> wordTypes) {
        switch (wordTypes.get(0).getWords()){
            case SENDARRAYHOSPITAL:
            case SENDARRAYCOFFEESHOP:
            case SENDARRAYSIGHT:
            case SENDARRAYBANK:
            case SENDARRAYRESTAURANT:
            case SENDARRAYHOTEL:
            case SENDARRAYMUSEUM:
                if (wordTypes.get(1).getWords() == Words.TOWN) {
                    return wordTypes.get(0).getPlace() + "/" + wordTypes.get(0).getPlace();
                }
            case SENDCOFFEESHOP:
            case SENDSIGHT:
            case HOSPITAL:
            case SENDHOTEL:
            case SENDBANK:
            case SENDRESTAURANT:
            case SENDMUSEUM:
                switch(wordTypes.get(1).getWords()){
                    case SIGHT:
                    case HOSPITAL:
                    case COFFEESHOP:
                    case BANK:
                    case HOTEL:
                    case RESTAURANT:
                    case MUSEUM:
                        return wordTypes.get(1).getPlace()+"/"+wordTypes.get(0).getPlace();
                }
            case SENDARRAYFOO:
                return wordTypes.get(0).getPlace();
        }
        throw  new IllegalStateException();
    }

    private String setCorrectTownString(String place) {
        return place.substring(0,1).toUpperCase() + place.substring(1).toLowerCase();
    }


}