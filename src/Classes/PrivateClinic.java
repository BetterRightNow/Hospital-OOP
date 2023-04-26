package Classes;

import Interfaces.HospitalInformation;

public class PrivateClinic extends Hospital implements HospitalInformation {
    private String brandName;

    public PrivateClinic(String name, Address address, String brandName) {
        super(name, address);
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
        return "\nBrandname of private clinic is " + brandName +
                " The name of hospital is " + getName() +
                "\nthe hospital address is" + getAddress();
    }
}
