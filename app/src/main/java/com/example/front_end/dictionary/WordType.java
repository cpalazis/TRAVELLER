package com.example.front_end.dictionary;

public class WordType {
    private String place;
    private Words words;

    public WordType() {
    }

    public WordType(String place, Words words) {
        this.place = place;
        this.words = words;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setWords(Words words) {
        this.words = words;
    }

    public Words getWords() {
        return words;
    }
}
