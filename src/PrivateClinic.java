public class PrivateClinic extends Hospital {
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
    public String toString () {
        return "\nBrandname of private clinic is " + brandName + " The name of hospital is " + getName() + "\nthe hospital address is" + getAddress();
    }
}
