package com.mycompany;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.Exceptions.DatabaseActionException;

import com.mycompany.models.dao.MovieDAOimplement;
import com.mycompany.models.entities.Movie;

public class MovieServlet extends HttpServlet {
    private MovieDAOimplement movieDAO;
    static final String TABLE_NAME = "users";
    static final String DB_URL = "jdbc:mysql://localhost:3306/movies?allowPublicKeyRetrieval=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "123monkey123";

    @Override
    public void init() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            movieDAO.MovieDAOImpl(connection);
            movieDAO.createTable();
        } catch (Exception e) {
            throw new RuntimeException("Lỗi tạo Servlet", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/list";

        }
        try {
            switch (action) {
                case "/view":
                    viewMovie(req, res);
                    break;
                case "/add":
                    showAddForm(req, res);
                    break;
                case "/edit":
                    showEditForm(req, res);
                    break;
                case "/delete":
                    showDeleteForm(req, res);
                    break;
                case "/list":   
                default:
                    listMovie(req, res);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi xử lý yêu cầu", e);

        }
    }

    private void listMovie(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Movie> movies = movieDAO.findAll();
        req.setAttribute("movies", movies);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/page/list.jsp");
        dispatcher.forward(req, res);
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse res)  throws IOException, DatabaseActionException {
        int id = Integer.parseInt(req.getParameter("id"));
        movieDAO.deleteMovie(id);

        res.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Optional<Movie> existingMovie = movieDAO.findMovieByID(id);

        req.setAttribute("movie", existingMovie.orElse(null));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/page/edit.jsp");
        dispatcher.forward(req, res);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/page/add.jsp");
        dispatcher.forward(req, res);
    }

    private void viewMovie(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Optional<Movie> movie = movieDAO.findMovieByID(id);
        req.setAttribute("movie", movie.orElse(null));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/page/view.jsp");
        dispatcher.forward(req, res);


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        String action = req.getPathInfo();
      
        try {
            switch (action) {
                case "/add":
                    addMovie(req, res);
                    break;
                
                case "/edit":
                    updateMovie(req, res);
                    break;         
                default:
                    res.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi xử lý yêu cầu POST", e);

        }
    }

    private void addMovie(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException, DatabaseActionException {
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        int yearOfRelease = Integer.parseInt(req.getParameter("yearOfRelease"));

        Movie newMovie = new Movie(0, title, genre, yearOfRelease);
        movieDAO.createMovie(newMovie);

        resp.sendRedirect("list");
    }

    private void updateMovie(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, DatabaseActionException {
        int id = Integer.parseInt(req.getParameter("id"));
        String newTitle = req.getParameter("title");

        Optional<Movie> existingMovie = movieDAO.findMovieByID(id);

        if (existingMovie.isPresent()) {
            movieDAO.updateMovieTitle(id, newTitle);
            resp.sendRedirect("list");
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
}
