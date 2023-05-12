package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidCountryException;
import com.solvd.laba.Interfaces.HospitalInformation;

import java.util.function.Function;

public class RegionalHospital extends Hospital implements HospitalInformation {
    private String region;

    public RegionalHospital(String name, Address address, String region) throws InvalidCountryException {
        super(name, address);
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public Address hospAddress() {
        return address;
    }

    @Override
    public String hospName() {
        return name;
    }

    public void regionReport () {
        Function<RegionalHospital, String> rep = (n) -> "in " + region + " there is a regional hospital";
        System.out.println(rep.apply(this));
    }

    @Override
    public String toString () {
        return "\nThe region of regional hospital is " + region +
                " The name of hospital is " + getName() +
                "\nthe hospital address is" + getAddress();
    }
}
