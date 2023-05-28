package com.solvd.laba.exceptions;

public class InvalidAddressException extends IllegalArgumentException {
    public InvalidAddressException (String message) {
        super(message);
    }
}
