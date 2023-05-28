package com.solvd.laba.classes;

import com.solvd.laba.enums.OperationType;

public class Operations {
    private OperationType operationType;
    private Patients patient;

    public Operations(OperationType operationType, Patients patient) {
        this.operationType = operationType;
        this.patient = patient;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Operation " +
                 operationType +
                " is scheduled for " +
                patient.getPatName() + " " +
                patient.getPatSurname();
    }
}
