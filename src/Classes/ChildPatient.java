package Classes;

import Interfaces.IAdmit;
import Interfaces.IHospital;
import Interfaces.ITransportable;
import Interfaces.Inspectable;
import enums.Disease;
import enums.DrugType;

public class ChildPatient extends Patients implements Inspectable, ITransportable, IAdmit {
    private String parentName;

    public ChildPatient(String patName, String patSurname, Disease disease, Address address, String parentName) {
        super(patName, patSurname, disease, address);
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public void inspect(Disease disease) {
        if (disease == Disease.HEALTHY_PATIENT) {
            System.out.println("Patient " + patName + " is healthy");
        } else {
            System.out.println("Inspecting child patient with disease type: " + disease);
        }
    }

    @Override
    public void transport(IHospital iHospital) {
        System.out.println("\nTransporting child patient from home address" + address + "\nto the " + iHospital.hospName() + iHospital.hospAddress());
    }

    @Override
    public void admit(IHospital iHospital) {
        System.out.println("Admitting child patient " + patName + " into " + iHospital.hospName());
    }

    @Override
    public void prescribeDrug (Disease disease, Drugs drugs) {
        switch (disease) {
            case FLU:
                System.out.println("\nDear " + parentName +
                        " your child " + patName + " " + patSurname +
                        " needs to take drugs " + drugs.getName() + " without prescription");
                break;
            case COLDS:
                System.out.println("\nDear " + parentName +
                        " your child " + patName + " " + patSurname +
                        " needs to take drugs " + drugs.getName() + " and you need a prescription");
                break;
            case ANGINA:
                if (drugs.getDrugType() == DrugType.ANTIBIOTIC) {
                    System.out.println("\nDear " + parentName +
                            " your child " + patName + " " + patSurname +
                            " needs to take drugs " + drugs.getName() + ", it is an Antibiotic");
                } else {
                    System.out.println("\nDear " + parentName +
                            " your child " + patName + " " + patSurname +
                            " needs to take drugs " + drugs.getName() + " without prescription");
                }
                break;
            default:
                System.out.println("\nDear " + parentName +
                        " your child " + patName + " " + patSurname +
                        " needs to take vitamins C");
                break;
        }
    }
}
