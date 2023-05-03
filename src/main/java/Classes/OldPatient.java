package Classes;

import Interfaces.HospitalAdmission;
import Interfaces.HospitalInformation;
import Interfaces.ITransportable;
import Interfaces.PatientInspection;
import enums.Disease;
import enums.DrugType;

import java.util.HashSet;
import java.util.Set;

public class OldPatient extends Patients implements PatientInspection, ITransportable, HospitalAdmission {
    private String childName;
    private static Set<OldPatient> oldPatList = new HashSet<OldPatient>();

    public OldPatient(String patName, String patSurname, Disease disease, Address address, String childName) {
        super(patName, patSurname, disease, address);
        this.childName = childName;
        oldPatList.add(this);
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OldPatient that)) return false;
        if (!super.equals(o)) return false;

        return getChildName().equals(that.getChildName());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getChildName().hashCode();
        return result;
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

    @Override
    public String toString() {
        return "OldPatient{" +
                "childName='" + childName + '\'' +
                ", patName='" + patName + '\'' +
                ", patSurname='" + patSurname + '\'' +
                ", disease=" + disease +
                ", address=" + address +
                '}';
    }

    public static void returnAllOldPatients () {
        for (OldPatient i: oldPatList) {
            System.out.println(i);
        }
    }
}
