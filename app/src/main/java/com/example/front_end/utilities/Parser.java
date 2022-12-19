package com.example.front_end.utilities;

import com.example.front_end.dictionary.WordType;
import com.example.front_end.dictionary.Words;
import com.example.front_end.dictionary.ParsedRequest;
import java.util.ArrayList;
import java.util.HashMap;


public class Parser {

    static HashMap<String, Words> dictionary = new HashMap<>();

    public static void initDictionary() {
        dictionary.put("sight", Words.SIGHT);
        dictionary.put("sights", Words.ARRAYLIST);
        dictionary.put("nearbysights", Words.ARRAYLIST);
        dictionary.put("hospital", Words.HOSPITAL);
        dictionary.put("hospitals", Words.ARRAYLIST);
        dictionary.put("nearbyhospitals", Words.ARRAYLIST);
        dictionary.put("coffeeshop", Words.COFFEESHOP);
        dictionary.put("coffeeshops", Words.ARRAYLIST);
        dictionary.put("nearbycoffeeshops", Words.ARRAYLIST);
        dictionary.put("towns", Words.ARRAYLIST);
        dictionary.put("cities", Words.ARRAYLIST);
        dictionary.put("topcities", Words.ARRAYLIST);
        dictionary.put("toptowns", Words.ARRAYLIST);
        dictionary.put("top5cities", Words.ARRAYLIST);
        dictionary.put("top5towns", Words.ARRAYLIST);
    }


    public ParsedRequest runParser(ArrayList<String> arrayList){
        return processList(arrayList);
    }

    private ParsedRequest processList(ArrayList<String> list) {
        int size = findListSize(list);
        return findTheClass(list, size);
    }

    private ParsedRequest findTheClass(ArrayList<String> list, int size) {
        switch(size){
            case 1:
                return processOneClass(list.get(0));

            case 2:
                return processTwoClass(list);

            case 3:
                return processThreeClass(list);

        }
        throw new IllegalStateException("Wrong size: "+size);
    }

    private ParsedRequest processThreeClass(ArrayList<String> list) {

        switch (list.get(2)){
            case "nearbysights":
                return new ParsedRequest(Words.SENDSIGHT, new WordType(list.get(2), Words.ARRAYLIST));

            case "nearbyhospitals":
                return new ParsedRequest(Words.SENDHOSPITAL, new WordType(list.get(2), Words.ARRAYLIST));

            case "nearbycoffeeshops":
                return new ParsedRequest(Words.SENDCOFFEESHOP, new WordType(list.get(2), Words.ARRAYLIST));

        }
        throw new IllegalStateException("Wrong word: "+list.get(2));
    }

    private ParsedRequest processTwoClass(ArrayList<String> list) {

        switch (list.get(1)){
            case "sights":
            case "nearbysights":
                return new ParsedRequest(Words.SENDSIGHT, new WordType(list.get(1), Words.ARRAYLIST));

            case "hospitals":
            case "nearbyhospitals":
                return new ParsedRequest(Words.SENDHOSPITAL, new WordType(list.get(1), Words.ARRAYLIST));

            case "coffeshops":
            case "nearbycoffeeshops":
                return new ParsedRequest(Words.SENDCOFFEESHOP, new WordType(list.get(1), Words.ARRAYLIST));

        }
        throw new IllegalStateException("Wrong word; "+list.get(1));
    }

    private ParsedRequest processOneClass(String string) {
        WordType wordtype;

        return new ParsedRequest(Words.SENDTOWN, new WordType(string, Words.TOWN));

    }



    static int findListSize(ArrayList<String> arrayList){
        return arrayList.size();
    }

}
