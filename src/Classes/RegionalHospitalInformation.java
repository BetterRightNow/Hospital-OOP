package Classes;

import Interfaces.HospitalInformation;

public class RegionalHospitalInformation extends Hospital implements HospitalInformation {
    private String region;

    public RegionalHospitalInformation(String name, Address address, String region) {
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

    @Override
    public String toString () {
        return "\nThe region of regional hospital is " + region +
                " The name of hospital is " + getName() +
                "\nthe hospital address is" + getAddress();
    }
}
