package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidCountryException;
import com.solvd.laba.Interfaces.PrintTeam;
import com.solvd.laba.Interfaces.HospitalInformation;

import java.util.function.Supplier;

public class EmergencyHospital extends Hospital implements HospitalInformation {
    private int ambulancesNum;

    public EmergencyHospital(String name, Address address, int ambulancesNum) throws InvalidCountryException {
        super(name, address);
        this.ambulancesNum = ambulancesNum;
    }

    public int getAmbulancesNum() {
        return ambulancesNum;
    }

    public void setAmbulancesNum(int ambulancesNum) {
        this.ambulancesNum = ambulancesNum;
    }

    public static void createExampleObj (Supplier<EmergencyHospital> createExample) {
        EmergencyHospital example = createExample.get();
        System.out.println(example.name + " object was created");
    }

    public void ambulanceTeam (PrintTeam<EmergencyHospital, String> teamFilter) {
        System.out.println(teamFilter.printTeam(this));
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
        return "\nNumber of ambulances is " + ambulancesNum +
                " The name of hospital is " + getName() +
                "\nthe hospital address is" + getAddress();
    }
}
