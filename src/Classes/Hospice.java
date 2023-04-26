package Classes;

import Interfaces.HospitalInformation;

public class Hospice extends Hospital implements HospitalInformation {
    private int maxPatientsNum;

    public Hospice(String name, Address address, int maxPatientsNum) {
        super(name, address);
        this.maxPatientsNum = maxPatientsNum;
    }

    public int getMaxPatientsNum() {
        return maxPatientsNum;
    }

    public void setMaxPatientsNum(int maxPatientsNum) {
        this.maxPatientsNum = maxPatientsNum;
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
