package com.example.front_end.objects;

import java.util.List;

public class Sight {

    private String name;
    private String city;
    private double lat;
    private double lng;
    private float rate;
    private List<String> images;
    private List<CoffeeShop> coffeeShops;
    private List<Hospital> hospitals;

    public Sight() {
    }

    public Sight(String name, String city, double lat, double lng, float rate,
                 List<String> images, List<CoffeeShop> coffeeShops, List<Hospital> hospitals) {
        this.name = name;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.rate = rate;
        this.images = images;
        this.coffeeShops = coffeeShops;
        this.hospitals = hospitals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<CoffeeShop> getCoffeeShops() {
        return coffeeShops;
    }

    public void setCoffeeShops(List<CoffeeShop> coffeeShops) {
        this.coffeeShops = coffeeShops;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
}
