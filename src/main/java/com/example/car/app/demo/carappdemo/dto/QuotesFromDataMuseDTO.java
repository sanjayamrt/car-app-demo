package com.example.car.app.demo.carappdemo.dto;

import java.util.List;

public class QuotesFromDataMuseDTO {

    private String word;

    private int score;

    private String[] tags;

    public QuotesFromDataMuseDTO(String word, int score, String[] tags) {
        this.word = word;
        this.score = score;
        this.tags = tags;
    }

    public String getWord() {
        return word;
    }

    public int getScore() {
        return score;
    }

    public String[] getTags() {
        return tags;
    }
}
