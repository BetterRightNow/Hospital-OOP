public class EmergencyHospital extends Hospital{
    private int ambulancesNum;

    public EmergencyHospital(String name, Address address, int ambulancesNum) {
        super(name, address);
        this.ambulancesNum = ambulancesNum;
    }

    public int getAmbulancesNum() {
        return ambulancesNum;
    }

    public void setAmbulancesNum(int ambulancesNum) {
        this.ambulancesNum = ambulancesNum;
    }

    public void printEmergHospInfo () {
        System.out.println("\nNumber of ambulances is " + ambulancesNum + " The name of hospital is " + getName() + "\nthe hospital address is" + getAddress());
    }
}
