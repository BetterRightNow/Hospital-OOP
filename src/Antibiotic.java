public class Antibiotic extends Drugs{
    private String instruction;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }



    public Antibiotic(String name, boolean prescription, String instruction) {
        super(name, prescription);
        this.instruction = instruction;
    }

    public void printAntibioticInfo () {
        if (prescription) {
            System.out.println("\nIt is an Antibiotic " + getName() + "\nyou need a prescription for it " + "\nhow to use" + instruction);
        } else {
            System.out.println("\nIt is an Antibiotic " + getName() + "\nhow to use: " + instruction);
        }
    }
}
