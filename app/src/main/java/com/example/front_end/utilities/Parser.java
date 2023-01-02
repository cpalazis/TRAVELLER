package com.example.front_end.utilities;

import com.example.front_end.dictionary.WordType;
import com.example.front_end.dictionary.Words;
import com.example.front_end.dictionary.ParsedRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Parser {


    public ParsedRequest runParser(HashMap<String, Words> map) {
        ArrayList<WordType> arrayList = new ArrayList<>();
        return new ParsedRequest(setTheArrayList(map, arrayList));
    }

    private ArrayList<WordType> setTheArrayList(HashMap<String, Words> map, ArrayList<WordType> list) {
        int i = 0;
        for(Map.Entry<String, Words> entry : map.entrySet()){
            list.add(i, new WordType(entry.getKey(), entry.getValue()));
            i++;
        }
        return list;
    }
}
