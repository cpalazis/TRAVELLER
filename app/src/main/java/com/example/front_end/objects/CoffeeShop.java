package com.example.front_end.objects;

public class CoffeeShop {

    private String name;
    private String placeId;
    private String vicinity;
    private float rate;
    private double lat;
    private double lng;

    public CoffeeShop() {
    }

    public CoffeeShop(String name, String placeId, String vicinity, float rate, double lat, double lng) {
        this.name = name;
        this.placeId = placeId;
        this.vicinity = vicinity;
        this.rate = rate;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
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
}
