package com.example.kimdemon.agricultureapp.models;

import android.content.Context;
import android.graphics.Bitmap;

public class HomeNews {
    private String title;
    private String author;
    private String source;
    private String date;
    private int image;
    private Context context;
    private String read;

    public HomeNews(String title, String date, int image, String read) {
        this.title = title;
        this.date = date;
        this.image = image;
        this.read = read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }
}
