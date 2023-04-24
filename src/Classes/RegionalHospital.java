package Classes;

public class RegionalHospital extends Hospital {
    private String region;

    public RegionalHospital(String name, Address address, String region) {
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
    public String toString () {
        return "\nThe region of regional hospital is " + region +
                " The name of hospital is " + getName() +
                "\nthe hospital address is" + getAddress();
    }
}
