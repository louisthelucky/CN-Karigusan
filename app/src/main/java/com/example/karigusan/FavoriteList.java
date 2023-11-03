package com.example.karigusan;

public class FavoriteList {

    private String brief;
    private int img;

    public FavoriteList(String brief, int img) {
        this.brief = brief;
        this.img = img;
    }

    public String getBrief() {
        return brief;
    }

    public int getImg() {
        return img;
    }
}
