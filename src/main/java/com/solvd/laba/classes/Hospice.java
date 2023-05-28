package com.solvd.laba.classes;

import com.solvd.laba.exceptions.InvalidCountryException;
import com.solvd.laba.interfaces.HospitalInformation;

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

    public void isLarge (Predicate<Integer> checkLarge) {
        if (checkLarge.test(maxPatientsNum)) {
            System.out.println(name + " is large");
        } else {
            System.out.println(name + " is small");
        }
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
