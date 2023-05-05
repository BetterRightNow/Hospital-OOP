package com.solvd.laba.enums;

public enum StaffType {
    DRIVER,
    CLEANER,
    SECURITY;

    @Override
    public String toString() {
        String result = "";
        switch (this) {
            case DRIVER -> result += "driver";
            case CLEANER -> result += "cleaner";
            case SECURITY -> result += "security";
            default -> result += "please insert type of non medical staff";
        }
        return result;
    }
}

