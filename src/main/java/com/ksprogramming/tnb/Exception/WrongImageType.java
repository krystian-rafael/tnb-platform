package com.ksprogramming.tnb.Exception;

public class WrongImageType extends RuntimeException{
    public WrongImageType() {
    }

    public WrongImageType(String message) {
        super(message);
    }
}
