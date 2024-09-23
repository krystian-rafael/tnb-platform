package com.ksprogramming.tnb.Exception;

public class NoAttributeWithThatId extends RuntimeException{
    public NoAttributeWithThatId() {
    }

    public NoAttributeWithThatId(String message) {
        super(message);
    }
}
