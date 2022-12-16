package com.example.front_end.objects;

import java.util.List;

public class Town {

    private String name;
    private String city;
    private double lat;
    private double lng;
    private float avgRating;
    private long totalRatings;
    private String body;
    private String excerpt;
    private List<String> images;



    public Town() {
    }

    public Town(String name, String city, double lat, double lng,
                float rate, long total_rating, String information,
                String information2, List<String> images ) {
        this.name = name;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.avgRating = rate;
        this.totalRatings = total_rating;
        this.body = information;
        this.excerpt= information2;
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

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public long getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(long totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }
}
