public class Dentistry extends Hospital{
    private int doctorsFee;

    public Dentistry(String name, Address address, int doctorsFee) {
        super(name, address);
        this.doctorsFee = doctorsFee;
    }

    public int getDoctorsFee() {
        return doctorsFee;
    }

    public void setDoctorsFee(int doctorsFee) {
        this.doctorsFee = doctorsFee;
    }

    public void printDentistryInfo () {
        System.out.println("\nThe name of hospice is " + getName() + "\nthe hospice address is" + getAddress() + "\nthe doctor fee is  " + doctorsFee + " EUR");
    }
}
