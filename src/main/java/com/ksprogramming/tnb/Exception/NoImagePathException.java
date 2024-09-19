package com.ksprogramming.tnb.Exception;

public class NoImagePathException extends RuntimeException{
    public NoImagePathException() {
        super();
    }

    public NoImagePathException(String message) {
        super(message);
    }
}
