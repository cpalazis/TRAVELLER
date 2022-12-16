package com.example.front_end.dictionary;


public class ParsedRequest {
    Words words;
    WordType wordType;

    public ParsedRequest() {
    }

    public ParsedRequest(Words words, WordType wordType) {
        this.words = words;
        this.wordType = wordType;
    }

    public WordType getWordType() {
        return wordType;
    }

    public void setWordType(WordType wordType) {
        this.wordType = wordType;
    }

    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }
}
