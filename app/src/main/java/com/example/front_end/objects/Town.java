package com.example.front_end.objects;

import java.util.List;

public class Town {

    private String name;
    private String city;
    private double lat;
    private double lng;
    private float rate;
    private long total_rating;
    private String information;
    private String information2;
    private List<String> images;
    private List<CoffeeShop> coffeeShops;
    private List<Hospital> hospitals;
    private List<Sight> sights;


    public Town() {
    }

    public Town(String name, String city, double lat, double lng,
                float rate, long total_rating, String information,
                String information2, List<String> images, List<CoffeeShop> coffeeShops,
                List<Hospital> hospitals, List<Sight> sights) {
        this.name = name;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.rate = rate;
        this.total_rating = total_rating;
        this.information = information;
        this.information2 = information2;
        this.images = images;
        this.coffeeShops = coffeeShops;
        this.hospitals = hospitals;
        this.sights = sights;
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

    public long getTotal_rating() {
        return total_rating;
    }

    public void setTotal_rating(long total_rating) {
        this.total_rating = total_rating;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getInformation2() {
        return information2;
    }

    public void setInformation2(String information2) {
        this.information2 = information2;
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

    public List<Sight> getSights() {
        return sights;
    }

    public void setSights(List<Sight> sights) {
        this.sights = sights;
    }
}
