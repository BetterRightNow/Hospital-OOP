package com.solvd.laba.classes;

import com.solvd.laba.interfaces.HospitalAdmission;
import com.solvd.laba.interfaces.ITransportable;
import com.solvd.laba.interfaces.PatientInspection;
import com.solvd.laba.enums.Disease;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patients patients)) return false;

        if (!getPatName().equals(patients.getPatName())) return false;
        if (!getPatSurname().equals(patients.getPatSurname())) return false;
        if (getDisease() != patients.getDisease()) return false;
        return getAddress().equals(patients.getAddress());
    }

    @Override
    public int hashCode() {
        int result = getPatName().hashCode();
        result = 31 * result + getPatSurname().hashCode();
        result = 31 * result + getDisease().hashCode();
        result = 31 * result + getAddress().hashCode();
        return result;
    }

    abstract protected void prescribeDrug(Disease disease, Drugs drugs);
}
