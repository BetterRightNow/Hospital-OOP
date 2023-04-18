public class Dentistry extends Hospital{
    private int doctorsfee;

    public int getDoctorsfee() {
        return doctorsfee;
    }

    public void setDoctorsfee(int doctorsfee) {
        this.doctorsfee = doctorsfee;
    }

    public Dentistry(String name, Address address, int doctorsfee) {
        super(name, address);
        this.doctorsfee = doctorsfee;
    }
    public void printDentistryInfo () {
        System.out.println("\nThe name of hospice is " + getName() + "\nthe hospice address is" + getAddress() + "\nthe doctor fee is  " + doctorsfee + " EUR");
    }
}
