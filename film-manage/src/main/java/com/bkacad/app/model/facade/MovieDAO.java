package com.bkacad.app.model.facade;



import java.util.List;

import com.bkacad.app.exception.DatabaseActionException;
import com.bkacad.app.exception.SeverErrorException;
import com.bkacad.app.exception.UserNotFoundException;
import com.bkacad.app.model.Movie;

public interface MovieDAO {
    void addMovie(Movie movie) throws SeverErrorException;

    void changeMovie(Movie movie) throws SeverErrorException;

    void deleteMovie(String title) throws SeverErrorException;

    List<Movie> listMovie() throws DatabaseActionException;

    Movie findMovie(String title) throws SeverErrorException, UserNotFoundException;
}
