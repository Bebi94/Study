package com.bkacad.app.model.facade;

import java.rmi.ServerError;

import com.bkacad.app.exception.SeverErrorException;
import com.bkacad.app.model.Movie;

public interface MovieDAO {
    public abstract void addMovie(Movie movie) throws SeverErrorException;
}
