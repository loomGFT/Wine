package com.example.wine.Exceptions;

public class WineryNotFoundException extends RuntimeException {

    public WineryNotFoundException(Long id) {
        super("Could not find winery " + id);
    }
}
