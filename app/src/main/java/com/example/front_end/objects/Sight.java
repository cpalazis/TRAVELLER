package com.example.front_end.objects;

import java.util.List;

public class Sight {

    private String name;
    private String city;
    private double lat;
    private double lng;
    private float avgRating;
    private long totalRatings;
    private String excerpt;
    private List<String> images;

    public Sight() {

    }

    public Sight(String name, String city, double lat, double lng, float rate,
                 long totalRatings, String excerpt, List<String> images) {
        this.name = name;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.avgRating = rate;
        this.totalRatings = totalRatings;
        this.excerpt = excerpt;
        this.images = images;
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



    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public long getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(long totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }
}
