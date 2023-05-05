package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidCountryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.Objects;

//1st class Classes.Hospital
public abstract class Hospital {
    public Logger countryLogger = LogManager.getLogger();
    protected String name;
    protected Address address;

    public Hospital(String name, Address address) throws InvalidCountryException {
        Configurator.initialize(null, "log4j2.xml");
        countryLogger.info("Application started");
        this.name = name;
        this.address = address;
        if (!Objects.equals(address.getCountry(), "Poland")) {
            countryLogger.error("Invalid country input. Acceptable only Poland");
            throw new InvalidCountryException("We work only in Poland");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }
}
