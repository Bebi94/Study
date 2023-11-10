package com.bkacad.app.view;

import java.util.Scanner;

import com.bkacad.app.controller.MovieController;
import com.bkacad.app.model.Movie;

public class MovieAddView extends AbstractView{

    public String title, genre;
    public int yearOfRelease;
    @Override
    public void render() throws Exception {
         Scanner scn = new Scanner(System.in);
        System.out.println("----");
        System.out.print("- Title: ");
        this.title = scn.nextLine();
        System.out.print("- Genre ");
        this.genre = scn.nextLine();
        System.out.print("- Year of Release: ");
        this.yearOfRelease = scn.nextInt();       
        MovieController.process(this).render();
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
    
    
}
