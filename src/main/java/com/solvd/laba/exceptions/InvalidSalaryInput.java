package com.solvd.laba.exceptions;

public class InvalidSalaryInput extends IllegalArgumentException{
    public InvalidSalaryInput (String message) {
        super(message);
    }
}
