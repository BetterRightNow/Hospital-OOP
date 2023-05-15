package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidCountryException;
import com.solvd.laba.Interfaces.HospitalInformation;

import java.util.function.Predicate;

public class Hospice extends Hospital implements HospitalInformation {
    private int maxPatientsNum;

    public Hospice(String name, Address address, int maxPatientsNum) throws InvalidCountryException {
        super(name, address);
        this.maxPatientsNum = maxPatientsNum;
    }

    public int getMaxPatientsNum() {
        return maxPatientsNum;
    }

    public void setMaxPatientsNum(int maxPatientsNum) {
        this.maxPatientsNum = maxPatientsNum;
    }

    public boolean isLarge (Predicate<Integer> checkLarge) {
        if (checkLarge.test(maxPatientsNum)) return true;
        return false;
    }

    @Override
    public Address hospAddress() {
        return address;
    }

    @Override
    public String hospName() {
        return name;
    }

    @Override
    public String toString () {
        return "\nThe name of hospice is " + getName() +
                "\nthe hospice address is" + getAddress() +
                "\nmax number of patients is " + maxPatientsNum;
    }
}
