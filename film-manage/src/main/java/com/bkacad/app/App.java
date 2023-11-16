package com.bkacad.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bkacad.app.controller.MovieController;
import com.bkacad.app.exception.AbstractException;
import com.bkacad.app.model.facade.MovieDAO;
import com.bkacad.app.model.implement.DBMovieManger;
import com.bkacad.app.view.ErrorView;
import com.bkacad.app.view.MenuView;

import lombok.Getter;

/**
 * Hello world!
 *
 */
public class App 
{
    static final String TABLE_NAME = "movies";
    static final String DB_URL = "jdbc:mysql://localhost:3306/film_manage?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "123monkey123";


    @Getter
    private static MovieController movieController;

    @Getter
    private static MovieDAO movieDAO;

    @Getter
    private static Scanner input;

    public static void init(){
        try {
            App.input = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            App.movieDAO = new DBMovieManger(connection);
            App.movieController = new MovieController(movieDAO);
           
        }
        catch (SQLException e){
            ErrorView err = new ErrorView("SQL: "+e.getMessage());
            err.render();
        }
    }
    public static void main( String[] args ) throws Exception
    {
        init();
        try {
            MenuView lgv = new MenuView();
            lgv.render();
        }
        catch (AbstractException e){
            ErrorView err = new ErrorView(e);
            err.render();
        }
    }
}

