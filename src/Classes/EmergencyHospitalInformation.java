package Classes;

import Exceptions.InvalidCountryException;
import Interfaces.HospitalInformation;

public class EmergencyHospitalInformation extends Hospital implements HospitalInformation {
    private int ambulancesNum;

    public EmergencyHospitalInformation(String name, Address address, int ambulancesNum) throws InvalidCountryException {
        super(name, address);
        this.ambulancesNum = ambulancesNum;
    }

    public int getAmbulancesNum() {
        return ambulancesNum;
    }

    public void setAmbulancesNum(int ambulancesNum) {
        this.ambulancesNum = ambulancesNum;
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
