package com.example.front_end.utilities;

import com.example.front_end.dictionary.Words;
import com.example.front_end.objects.*;

import java.util.ArrayList;
import java.util.HashMap;

public class UtilityClass {
    private static UtilityClass instance;
    private ArrayList<Town> townList;
    private ArrayList<Sight> sightList;
    private ArrayList<CoffeeShop> coffeeShopList;
    private ArrayList<Hospital> hospitalList;
    private ArrayList<Double> location;
    private ArrayList<String> imagesUrl;
    private HashMap<String, Words> mapList;

    private UtilityClass(){}

    public static UtilityClass getInstance(){
        if(instance == null){
            instance = new UtilityClass();
        }
        return instance;
    }

    public ArrayList<Sight> getSightList() {
        return sightList;
    }

    public void setSightList(ArrayList<Sight> sightList) {
        this.sightList = sightList;
    }

    public ArrayList<Town> getTownList() {
        return townList;
    }

    public void setTownList(ArrayList<Town> townList) {
        this.townList = townList;
    }

    public ArrayList<CoffeeShop> getCoffeeShopList() {
        return coffeeShopList;
    }

    public void setCoffeeShopList(ArrayList<CoffeeShop> coffeeShopList) {
        this.coffeeShopList = coffeeShopList;
    }

    public ArrayList<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(ArrayList<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public HashMap<String, Words> getMapList() {
        return mapList;
    }

    public void setMapList(HashMap<String, Words> mapList) {
        this.mapList = mapList;
    }

    public ArrayList<Double> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<Double> location) {
        this.location = location;
    }

    public ArrayList<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(ArrayList<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }
}
