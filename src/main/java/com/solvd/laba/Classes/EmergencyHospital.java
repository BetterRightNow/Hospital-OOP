package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidCountryException;
import com.solvd.laba.Interfaces.HospitalInformation;

import java.util.function.Supplier;

interface Ambulance<T, R> {
    R apply(T t);
}

public class EmergencyHospital extends Hospital implements HospitalInformation {
    private int ambulancesNum;
    private int floorsNumber;

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

    public static Supplier<EmergencyHospital> exampleEmergObj = () -> {
        String exampleName = "exampleName";
        Address exampleAddress = new Address("Poland", "ExampleCity", "ExampleStreet", 1);
        int exampleAmbNub = 10;
        return new EmergencyHospital(exampleName, exampleAddress, exampleAmbNub);
    };

    public String ambulanceTeam () {
        final int[] ambData = new int[3];
        Ambulance<EmergencyHospital, String> amb = (EmergencyHospital hospital) -> {
            ambData[0] = ambulancesNum;
            ambData[1] = ambulancesNum * 2;
            ambData[2] = ambulancesNum;
            String ambTeam = "Ambulance team is " +
                    ambData[0] + " drivers, " +
                    ambData[1] + " nurses and " +
                    ambData[2] + " doctors.";
            return ambTeam;
        };
        return amb.apply(this);
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
