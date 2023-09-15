package com.example.bottom_bar.Model;

public class MatchedModel {


    private final int imageResource;
    private final String title;

    public MatchedModel(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }
}



