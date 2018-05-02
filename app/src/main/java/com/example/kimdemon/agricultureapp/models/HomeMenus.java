package com.example.kimdemon.agricultureapp.models;

import com.example.kimdemon.agricultureapp.activity.AgricultureProfessorActivity;

public class HomeMenus {
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getUrl() {
        return url;
    }

    public void setUrl(Class url) {
        this.url = url;
    }

    private int image;
    private String name;
    private Class url;

    public HomeMenus(int image, String name, Class url) {
        this.image = image;
        this.name = name;
        this.url = url;
    }

}
