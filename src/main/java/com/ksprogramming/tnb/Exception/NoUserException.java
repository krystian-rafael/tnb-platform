package com.ksprogramming.tnb.Exception;
public class NoUserException extends RuntimeException{
    public NoUserException() {
        super();
    }

    public NoUserException(String message) {

        super(message);
    }
}