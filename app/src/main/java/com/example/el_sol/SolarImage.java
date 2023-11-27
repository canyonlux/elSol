package com.example.el_sol;

public class SolarImage {
    private int imageResourceId;
    private String title;

    // Constructor
    public SolarImage(int imageResourceId, String title) {
        this.imageResourceId = imageResourceId;
        this.title = title;
    }

    // Getters
    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
