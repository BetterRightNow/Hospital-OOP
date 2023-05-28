package com.solvd.laba.exceptions;

public class InvalidCountryException extends IllegalArgumentException{
    public InvalidCountryException(String message) {
        super(message);
    }
}
