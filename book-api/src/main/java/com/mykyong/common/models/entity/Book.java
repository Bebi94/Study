package com.mykyong.common.models.entity;
import lombok.Setter;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true, chain = true)
@Getter
@Setter

public class Book {
    private int id;
    private String title;
    private String author;
    private int yearOfRelease;

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }

    public int getYearOfRelease(){
        return yearOfRelease;
    }

}
