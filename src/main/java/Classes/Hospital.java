package Classes;

import Exceptions.InvalidCountryException;

import java.util.Objects;

//1st class Classes.Hospital
public abstract class Hospital {
    protected String name;
    protected Address address;

    public Hospital(String name, Address address) throws InvalidCountryException {
        this.name = name;
        this.address = address;
        if (!Objects.equals(address.getCountry(), "Poland")) {
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
