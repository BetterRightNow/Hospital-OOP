public class Hospice extends Hospital{
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
    public String toString () {
        return "\nThe name of hospice is " + getName() + "\nthe hospice address is" + getAddress() + "\nmax number of patients is " + maxPatientsNum;
    }
}
