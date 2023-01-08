package com.example.front_end.objects;

import java.util.List;

public class CoffeeShop {

    private String name;
    private String placeId;
    private String vicinity;
    private float rating;
    private double lat;
    private double lng;
    private String body;
    private List<String> images;

    public CoffeeShop() {
    }

    public CoffeeShop(String name, String placeId, String vicinity, float rate, double lat, double lng,
                      String body, List<String> images) {
        this.name = name;
        this.placeId = placeId;
        this.vicinity = vicinity;
        this.rating = rate;
        this.lat = lat;
        this.lng = lng;
        this.body = body;
        this.images = images;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
