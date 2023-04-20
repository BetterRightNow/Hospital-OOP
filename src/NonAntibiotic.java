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

    @Override
    public String toString () {
        return "\nIt is not an Antibiotic " + getName() + (prescription ? "\nyou need a prescription for it " : "") + "\nhow to use" + instruction;
    }
}
