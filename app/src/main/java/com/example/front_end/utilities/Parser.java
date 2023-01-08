package com.example.front_end.utilities;

import com.example.front_end.dictionary.WordType;
import com.example.front_end.dictionary.Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Parser {


    public ParsedRequest processHashMap(HashMap<String, Words> map) {
        ArrayList<WordType> typeArrayList = getTheArrayList(map);
        return new ParsedRequest(typeArrayList);
    }

    private ArrayList<WordType> getTheArrayList(HashMap<String, Words> map) {
        ArrayList<WordType> list = new ArrayList<>();
        int i = 0;
        for(Map.Entry<String, Words> entry : map.entrySet()){
            list.add(i, new WordType(entry.getKey(), entry.getValue()));
            i++;
        }
        return list;
    }

}
