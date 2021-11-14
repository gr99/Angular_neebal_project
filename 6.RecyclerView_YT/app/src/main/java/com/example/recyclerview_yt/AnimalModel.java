package com.example.recyclerview_yt;

public class AnimalModel {
    String animalName;
    int image;

    public AnimalModel(String animalName, int image) {
        this.animalName = animalName;
        this.image = image;
    }

    public String getAnimalName() {
        return animalName;
    }

    public int getImage() {
        return image;
    }
}
