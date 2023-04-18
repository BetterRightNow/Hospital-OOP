public class RegionalHospital extends Hospital {
    private String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public RegionalHospital(String name, Address address, String region) {
        super(name, address);
        this.region = region;
    }
    public void printRegionalHospitalDetails () {
        System.out.println("\nThe region of regional Hospital is " + region + " The name of hospital is " + getName() + "\nthe hospital address is" + getAddress());
    }
}
