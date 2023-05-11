package com.solvd.laba.enums;

public enum StaffType {
    DRIVER (25),
    CLEANER (21),
    SECURITY (23);

    private int vacation;

    StaffType(int vacation) {
        this.vacation = vacation;
    }

    public int getVacation() {
        return vacation;
    }

    public void setVacation(int vacation) {
        this.vacation = vacation;
    }

    public void vacation() {
        System.out.println("Employee have" + vacation + " days of vacation");
    }

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

