package com.bkacad.app.controller;

import java.rmi.ServerError;

import com.bkacad.app.exception.SeverErrorException;
import com.bkacad.app.model.Movie;
import com.bkacad.app.model.facade.MovieDAO;
import com.bkacad.app.view.AbstractView;
import com.bkacad.app.view.MenuView;
import com.bkacad.app.view.MovieAddView;

public class MovieController {
    static MovieDAO movieDAO;
    public MovieController(MovieDAO movieDAO){
        this.movieDAO = movieDAO;
    }
    public static AbstractView process(MovieAddView view) throws ServerError, SeverErrorException{
        movieDAO.addMovie(new Movie(view.title, view.genre, view.yearOfRelease));
        return new MenuView();
    }

     /*public static AbstractView process(String title) throws ServerError, SeverErrorException{
        movieDAO.deleteMovie(new Movie());
        return new MenuView();
    } */
    


}
