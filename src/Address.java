public class Address {
    private String country;
    private String city;
    private String street;
    private int house;

    public Address(String country, String city, String street, int house) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }


    public void printAddress () {
        System.out.println("\nCountry " + country + " City " + city + " street " + street + " " + house);
    }
    @Override
    public String toString () {
        return "\nCountry " + country + " City " + city + " street " + street + " " + house;
    }
}
