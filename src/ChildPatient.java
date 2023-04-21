public class ChildPatient extends Patients{
    private String parentName;

    public ChildPatient(String patName, String patSurname, Disease disease, String parentName) {
        super(patName, patSurname, disease);
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public void prescribeDrug (Disease disease, Drugs drugs) {
        switch (disease) {
            case FLU:
                System.out.println("\nDear " + parentName + " your child " + patName + " " + patSurname + " needs to take drugs " + drugs.getName() + " without prescription");
                break;
            case COLDS:
                System.out.println("\nDear " + parentName + " your child " + patName + " " + patSurname + " needs to take drugs " + drugs.getName() + " and you need a prescription");
                break;
            case ANGINA:
                if (drugs.getDrugType() == DrugType.ANTIBIOTIC) {
                    System.out.println("\nDear " + parentName + " your child " + patName + " " + patSurname + " needs to take drugs " + drugs.getName() + ", it is an Antibiotic");
                } else {
                    System.out.println("\nDear " + parentName + " your child " + patName + " " + patSurname + " needs to take drugs " + drugs.getName() + " without prescription");
                }
                break;
            default:
                System.out.println("\nDear " + parentName + " your child " + patName + " " + patSurname + " needs to take vitamins C");
                break;
        }
    }
}
