package com.solvd.laba.Exceptions;

public class InvalidCountryException extends IllegalArgumentException{
    public InvalidCountryException(String message) {
        super(message);
    }
}
