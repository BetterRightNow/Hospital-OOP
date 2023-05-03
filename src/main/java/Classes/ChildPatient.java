package Classes;

import Interfaces.HospitalAdmission;
import Interfaces.HospitalInformation;
import Interfaces.ITransportable;
import Interfaces.PatientInspection;
import enums.Disease;
import enums.DrugType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChildPatient extends Patients implements PatientInspection, ITransportable, HospitalAdmission {
    private String parentName;

    private static List<String> childPatList = new ArrayList<>();
    private static Map <ChildPatient, Disease> childPatMap = new HashMap<ChildPatient, Disease>();

    public ChildPatient(String patName, String patSurname, Disease disease, Address address, String parentName) {
        super(patName, patSurname, disease, address);
        this.parentName = parentName;
        childPatList.add(patName + " " + patSurname);
        childPatMap.put(this, disease);
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
    public void transport(HospitalInformation hospitalInformation) {
        System.out.println("\nTransporting child patient from home address" + address + "\nto the " + hospitalInformation.hospName() + hospitalInformation.hospAddress());
    }

    @Override
    public void admit(HospitalInformation hospitalInformation) {
        System.out.println("Admitting child patient " + patName + " into " + hospitalInformation.hospName());
    }

    public static void returnAllChildPat () {
        for (String i: childPatList) {
            System.out.println(i);
        }
    }

    public static void returnPatMap () {
        for (Map.Entry<ChildPatient, Disease> i: childPatMap.entrySet()) {
            System.out.println(i.getKey().getPatName() + " " + i.getKey().getPatSurname() + " " + i.getValue());
        }
    }

    @Override
    public String toString() {
        return "ChildPatient{" +
                "patName='" + patName + '\'' +
                ", patSurname='" + patSurname + '\'' +
                ", disease=" + disease +
                '}';
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
