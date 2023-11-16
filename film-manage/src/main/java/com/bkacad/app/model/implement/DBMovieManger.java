package com.bkacad.app.model.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bkacad.app.exception.DatabaseActionException;
import com.bkacad.app.exception.SeverErrorException;
import com.bkacad.app.exception.UserNotFoundException;
import com.bkacad.app.model.Movie;
import com.bkacad.app.model.facade.MovieDAO;

public class DBMovieManger implements MovieDAO {

    private Connection connection;

    public DBMovieManger(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addMovie(Movie movie) throws SeverErrorException {
        try {
            final String QUERRY = "INSERT INTO movies(title, genre, yearOfRelease) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(QUERRY);

            statement.setString(1, movie.title);
            statement.setString(2, movie.genre);
            statement.setInt(3, movie.yearOfRelease);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SeverErrorException("SQL: " + e.getMessage());
        }

    }

    @Override
    public void changeMovie(Movie movie) throws SeverErrorException {
        try {
            final String QUERY = "update movies set title=?, genre=?, yearOfRelease=?";
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, movie.title);
            statement.setString(2, movie.genre);
            statement.setInt(3, movie.yearOfRelease);
        } catch (SQLException e) {
            throw new SeverErrorException("SQL " + e.getMessage());
        }

    }

    @Override
    public void deleteMovie(String title) throws SeverErrorException {
        try {
            final String QUERY = "DELETE FROM movies WHERE title=?";
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, title);
        } catch (SQLException e) {
            throw new SeverErrorException("SQL " + e.getMessage());
        }
    }


    @Override
    public List<Movie> listMovie() throws DatabaseActionException {
        String sql = "SELECT * FROM movies";
        List<Movie> movies = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    movies.add(new Movie(resultSet.getString("title"),resultSet.getString("genre"), resultSet.getInt("yearOfRelease")));
                }
            }
            return movies;
        } catch (SQLException e) {
            throw new DatabaseActionException(sql);
        }
    }
   /*  @Override
    public ArrayList<Movie> listMovie() throws SeverErrorException, SQLException {
        
        try {
            final String QUERY = "select * from movies";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            ArrayList<Movie> movies = new ArrayList<>();

            while (resultSet.next()) {
                movies.add(new Movie(resultSet.getString("title"), resultSet.getString("genre"),
                        resultSet.getInt("yearOfRelease")));

            }
            return movies;
        } catch (SQLException e) {
            throw new SeverErrorException("SQL " + e.getMessage());
        }

    }*/

    @Override
    public Movie findMovie(String title) throws SeverErrorException, UserNotFoundException {
        try {
            final String QUERY = "SELECT * FROM movies WHERE movies.title=?";
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Movie(resultSet.getString("title"), resultSet.getString("genre"),
                        resultSet.getInt("yearOfReLease"));
            } else {
                throw new UserNotFoundException(title);
            }
        } catch (SQLException e) {
            throw new SeverErrorException("SQL " + e.getMessage());
        }
    }

}
