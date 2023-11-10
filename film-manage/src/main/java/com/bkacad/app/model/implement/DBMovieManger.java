package com.bkacad.app.model.implement;

import java.rmi.ServerError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.Query;

import com.bkacad.app.exception.SeverErrorException;
import com.bkacad.app.model.Movie;
import com.bkacad.app.model.facade.MovieDAO;

public class DBMovieManger implements MovieDAO {
    Connection connection;
    public DBMovieManger(Connection connection){
        this.connection = connection;
    }
    @Override
    public void addMovie(Movie movie) throws SeverErrorException {
        try {
            final String QUERRY = "INSET INTO movies(title, genre, yearOfRelease) VALES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(QUERRY);

            statement.setString(1, movie.title);
            statement.setString(2, movie.genre);
            statement.setInt(3, movie.yearOfRelease);
            statement.executeUpdate();            
        } catch (SQLException e) {
            throw new SeverErrorException("SQL: " + e.getMessage());
        }
        throw new UnsupportedOperationException("Unimplemented method 'addMovie'");
    }
    
}
