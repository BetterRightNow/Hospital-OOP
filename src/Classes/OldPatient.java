package Classes;

import Interfaces.HospitalAdmission;
import Interfaces.HospitalInformation;
import Interfaces.ITransportable;
import Interfaces.PatientInspection;
import enums.Disease;
import enums.DrugType;

public class OldPatient extends Patients implements PatientInspection, ITransportable, HospitalAdmission {
    private String childName;

    public OldPatient(String patName, String patSurname, Disease disease, Address address, String childName) {
        super(patName, patSurname, disease, address);
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    @Override
    public void inspect(Disease disease) {
        if (disease == Disease.HEALTHY_PATIENT) {
            System.out.println("Patient " + patName + " is healthy");
        } else {
            System.out.println("Inspecting old patient with disease type: " + disease);
        }
    }

    @Override
    public void transport(HospitalInformation hospitalInformation) {
        System.out.println("\nTransporting old patient from home address" + address + "\nto the " + hospitalInformation.hospName() + hospitalInformation.hospAddress());
    }

    @Override
    public void admit(HospitalInformation hospitalInformation) {
        System.out.println("Admitting old patient " + patName + " into " + hospitalInformation.hospName());
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
