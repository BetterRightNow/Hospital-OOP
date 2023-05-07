package com.solvd.laba.Exceptions;

public class InvalidSalaryInput extends IllegalArgumentException{
    public InvalidSalaryInput (String message) {
        super(message);
    }
}
