package com.bkacad.app.model.entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkacad.app.exception.SeverErrorException;
import com.bkacad.app.model.Movie;
import com.bkacad.app.model.implement.DBMovieManger;

public class DeleteServlet extends HttpServlet {
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
        
        PrintWriter printWriter = resp.getWriter();
        

        try {
            movieDAO.deleteMovie(title);
            printWriter.println("Movie Deleted");
           
        } catch (SeverErrorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
