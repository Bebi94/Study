package com.bkacad.app.model.entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkacad.app.exception.DatabaseActionException;
import com.bkacad.app.exception.SeverErrorException;
import com.bkacad.app.model.Movie;

import com.bkacad.app.model.implement.DBMovieManger;

public class MovieServlet extends HttpServlet {
    public DBMovieManger movieDAO;
    static final String TABLE_NAME = "users";
    static final String DB_URL = "jdbc:mysql://localhost:3306/film_manage?allowPublicKeyRetrieval=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "123monkey123";

    @Override
    public void init() {
        try {
            // Initialize the MovieDAOImpl with a Connection obtained from your DataSource
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            movieDAO = new DBMovieManger(connection);

        } catch (Exception e) {
            throw new RuntimeException("Error initializing MovieServlet", e);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        int yearOfReLease = Integer.parseInt(req.getParameter("yearOfRelease"));
        PrintWriter printWriter = resp.getWriter();

        Movie movie = new Movie(title, genre, yearOfReLease);

        try {
            movieDAO.addMovie(movie);
            printWriter.println("Add succeeded");
        } catch (SeverErrorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Movie> movies;
        try {
            movies = movieDAO.listMovie();
            req.setAttribute("movies", movies);
        // Forward the request to the JSP
        RequestDispatcher dispatcher = req.getRequestDispatcher("AddMovie.jsp");
         dispatcher.forward(req, resp);
        } catch (DatabaseActionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
       
    }


   

}
