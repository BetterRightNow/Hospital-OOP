package com.solvd.laba.Classes;


import com.solvd.laba.Exceptions.InvalidAddressException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Address {
    public Logger addressLogger = LogManager.getLogger();
    private String country;
    private String city;
    private String street;
    private int house;

    public Address(String country, String city, String street, int house)  throws InvalidAddressException {
        Configurator.initialize(null, "log4j2.xml");
        addressLogger.info("Application started");
        if (house <= 0 || country == null || city == null || street == null) {
            addressLogger.error("Invalid address input. It shouldn't be null or <= 0");
            throw new InvalidAddressException("Invalid address");
        }
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;

        if (getHouse() != address.getHouse()) return false;
        if (!getCountry().equals(address.getCountry())) return false;
        if (!getCity().equals(address.getCity())) return false;
        return getStreet().equals(address.getStreet());
    }

    @Override
    public int hashCode() {
        int result = getCountry().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getHouse();
        return result;
    }

    @Override
    public String toString () {
        return "\nCountry " + country +
                " City " + city +
                " street " + street + " " + house;
    }
}
