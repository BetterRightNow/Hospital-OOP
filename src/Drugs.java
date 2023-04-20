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

    public void printDrugInfo () {
        if (prescription) {
            System.out.println("\nDrug name is " + name + "\nyou need a prescription for it");
        } else {
            System.out.println("\nDrug name is " + name);
        }
    }

    @Override
    public String toString () {return "\nDrug name is " + prescription;}
}
