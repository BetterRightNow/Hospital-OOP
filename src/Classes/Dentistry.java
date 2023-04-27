package Classes;

import Exceptions.InvalidCountryException;

public class Dentistry extends Hospital {
    private int doctorsFee;

    public Dentistry(String name, Address address, int doctorsFee) throws InvalidCountryException {
        super(name, address);
        this.doctorsFee = doctorsFee;
    }

    public int getDoctorsFee() {
        return doctorsFee;
    }

    public void setDoctorsFee(int doctorsFee) {
        this.doctorsFee = doctorsFee;
    }

    @Override
    public String toString () {
        return "\nThe name of hospice is " + getName() +
                "\nthe hospice address is" + getAddress() +
                "\nthe doctor fee is " + doctorsFee + " EUR";
    }
}
