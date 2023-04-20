public class NonAntibiotic extends Drugs{
    private String instruction;

    public NonAntibiotic(String name, boolean prescription, String instruction) {
        super(name, prescription);
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void printNonAntibioticInfo () {
        if (prescription) {
            System.out.println("\nIt is not an Antibiotic " + getName() + "\nyou need a prescription for it " + "\nhow to use" + instruction);
        } else {
            System.out.println("\nIt is not an Antibiotic " + getName() + "\nhow to use: " + instruction);
        }
    }
}
