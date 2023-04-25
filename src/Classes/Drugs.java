package Classes;

import enums.DrugType;

public final class Drugs {
    private String name;
    private String instruction;
    private DrugType drugType;

    public Drugs(String name, String instruction, DrugType drugType) {
        this.name = name;
        this.instruction = instruction;
        this.drugType = drugType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public void setDrugType(DrugType drugType) {
        this.drugType = drugType;
    }

    @Override
    public String toString () {
        String result = "\ndrug name is " + name + "\nhow to use: " + instruction;
        switch (drugType) {
            case VITAMIN -> result += "\ntype of drug is vitamin";
            case ANTIBIOTIC -> result += "\ntype of drug is antibiotic";
            case PRESCRIPTION -> result += "\nyou need a prescription";
            case NON_PRESCRIPTION -> result += "\nit's an ordinary drug, you don't need a prescription";
            default -> result += "\ntype of drug is unknown";
        }
        return result;
    }
}
