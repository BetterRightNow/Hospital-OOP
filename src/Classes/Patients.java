package Classes;

import Interfaces.HospitalAdmission;
import Interfaces.ITransportable;
import Interfaces.PatientInspection;
import enums.Disease;

abstract public class Patients implements PatientInspection, ITransportable, HospitalAdmission {
    protected String patName;
    protected String patSurname;
    protected Disease disease;
    protected Address address;

    public Patients(String patName, String patSurname, Disease disease, Address address) {
        this.patName = patName;
        this.patSurname = patSurname;
        this.disease = disease;
        this.address = address;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatSurname() {
        return patSurname;
    }

    public void setPatSurname(String patSurname) {
        this.patSurname = patSurname;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    abstract protected void prescribeDrug(Disease disease, Drugs drugs);
}
