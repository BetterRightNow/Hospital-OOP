public class NonMedicalStaff extends Staff{
    private String kindOfStaff;

    public NonMedicalStaff(String name, String surname, String kindOfStaff) {
        super(name, surname);
        this.kindOfStaff = kindOfStaff;
    }

    public String getKindOfStaff() {
        return kindOfStaff;
    }

    public void setKindOfStaff(String kindOfStaff) {
        this.kindOfStaff = kindOfStaff;
    }

    public void printNonMedicInfo () {
        System.out.println("\nName" + getName() + " surname " + getSurname() + " working area " + kindOfStaff);
    }
}
