package com.bkacad.app.exception;

public class UserNotFoundException extends AbstractException {

    public UserNotFoundException(String title) {
        super("Movie " + title + "is not in the Movie List!");
        //TODO Auto-generated constructor stub
    }
    
}
