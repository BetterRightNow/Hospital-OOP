package Classes;

import enums.Disease;
import enums.DrugType;

public class OldPatient extends Patients{
    private String childName;

    public OldPatient(String patName, String patSurname, Disease disease, String childName) {
        super(patName, patSurname, disease);
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    @Override
    public void prescribeDrug(Disease disease, Drugs drugs) {
        switch (disease) {
            case FLU -> System.out.println("Dear " + childName +
                    " you parent " + patName + " " + patSurname
                    + " needs to take " + drugs.getName() + " without prescription");
            case COLDS -> System.out.println("\nDear " + childName +
                    " your parent " + patName + " " + patSurname +
                    " needs to take drugs " + drugs.getName() + " and you need a prescription");
            case ANGINA -> {
                if (drugs.getDrugType() == DrugType.ANTIBIOTIC) {
                    System.out.println("\nDear " + childName +
                            " your parent " + patName + " " + patSurname +
                            " needs to take drugs " + drugs.getName() + " it is an antibiotic");
                } else {
                    System.out.println("\nDear " + childName +
                            " your parent " + patName + " " + patSurname +
                            " needs to take drugs " + drugs.getName() + " without prescription");
                }
            }
            default -> System.out.println("\nDear " + childName +
                    " your parent " + patName + " " + patSurname +
                    " needs to take vitamins C");
        }
    }
}
