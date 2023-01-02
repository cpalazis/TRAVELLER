package com.example.front_end.dictionary;


import java.util.ArrayList;

public class ParsedRequest {
   private ArrayList<WordType> typeArrayList;

    public ParsedRequest() {
    }

    public ParsedRequest(ArrayList<WordType> typeArrayList) {
        this.typeArrayList = typeArrayList;
    }

    public ArrayList<WordType> getTypeArrayList() {
        return typeArrayList;
    }

    public void setTypeArrayList(ArrayList<WordType> typeArrayList) {
        this.typeArrayList = typeArrayList;
    }
}
