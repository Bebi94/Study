package com.bkacad.app.model;

public class Movie {
    public String title;
    public String genre;
    public int yearOfRelease;

    public Movie(String title, String genre, int yearOfRelease){
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }
}
