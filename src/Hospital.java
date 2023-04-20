//1st class Hospital
public class Hospital {
    private String name;
    private Address address;

    public Hospital(String name, Address address) {
        this.name = name;
        this.address = address;
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

    @Override
    public String toString () {
        return "\nThe name of hospital is " + name + "\nthe hospital address is " + address;
    }
}
