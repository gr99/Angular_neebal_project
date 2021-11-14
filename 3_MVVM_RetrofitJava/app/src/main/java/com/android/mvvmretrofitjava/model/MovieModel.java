package com.android.mvvmretrofitjava.model;

public class MovieModel {
    private String image;
    private String title;


    public MovieModel(String image,String title ) {
        this.title = title;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
