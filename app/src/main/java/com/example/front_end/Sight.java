package com.example.front_end;

import java.util.List;

public class Sight {
    private String name;
    private String city;
    private double lat;
    private double lng;
    private float rate;
    private long totalrate;
    private String information;
    private List<String> imageUrl;
    private List<Hospital> nearbyhospital;
    private List<CoffeShop> nearbyCoffeShop;

    public Sight() {
    }

    public Sight(String name, String city, double lat, double lng, float rate, long totalrate,
                 String information, List<String> imageUrl, List<Hospital> nearbyhospital, List<CoffeShop> nearbyCoffeShop) {
        this.name = name;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.rate = rate;
        this.totalrate = totalrate;
        this.information = information;
        this.imageUrl = imageUrl;
        this.nearbyhospital = nearbyhospital;
        this.nearbyCoffeShop = nearbyCoffeShop;
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

    public long getTotalrate() {
        return totalrate;
    }

    public void setTotalrate(long totalrate) {
        this.totalrate = totalrate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Hospital> getNearbyhospital() {
        return nearbyhospital;
    }

    public void setNearbyhospital(List<Hospital> nearbyhospital) {
        this.nearbyhospital = nearbyhospital;
    }

    public List<CoffeShop> getNearbyCoffeShop() {
        return nearbyCoffeShop;
    }

    public void setNearbyCoffeShop(List<CoffeShop> nearbyCoffeShop) {
        this.nearbyCoffeShop = nearbyCoffeShop;
    }
}
