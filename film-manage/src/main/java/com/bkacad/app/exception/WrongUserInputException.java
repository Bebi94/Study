
package com.bkacad.app.exception;

public class WrongUserInputException extends AbstractException{
    public WrongUserInputException(String reason){
        super(reason);
    }
}
