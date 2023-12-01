package com.mycompany.models.dao;

import java.util.List;
import java.util.Optional;

import com.mycompany.Exceptions.DatabaseActionException;
import com.mycompany.models.entities.Movie;

public interface MovieDAO {
    
    void createTable() throws DatabaseActionException;

    void deleteTable() throws DatabaseActionException;

    void createMovie(final Movie movie) throws DatabaseActionException;

    void deleteMovie(int id) throws DatabaseActionException;

    void updateMovieTitle(int id, String newTitle) throws DatabaseActionException;

    Optional<Movie> findMovieByID(int id) throws DatabaseActionException;

    List<Movie> findAll() throws DatabaseActionException;

}
