package com.solvd.laba.Exceptions;

public class InvalidAddressException extends IllegalArgumentException {
    public InvalidAddressException (String message) {
        super(message);
    }
}
