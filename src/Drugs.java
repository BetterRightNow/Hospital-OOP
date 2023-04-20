public class Drugs {
    private String name;
    public boolean prescription;

    public Drugs(String name, boolean prescription) {
        this.name = name;
        this.prescription = prescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString () {
        return "\nDrug name is " + name + (prescription ? "\nyou need a prescription for it" : "");
    }
}
