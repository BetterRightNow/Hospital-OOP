package com.solvd.laba.classes;

import com.solvd.laba.enums.Disease;
import com.solvd.laba.enums.RecordStatus;
import com.solvd.laba.enums.RecordType;
import com.solvd.laba.enums.Severity;

public class MedicalRecords {
    Disease disease;
    RecordType recordType;
    Severity severity;
    RecordStatus recordStatus;
    Patients patient;

    public MedicalRecords(Disease disease, RecordType recordType, Severity severity, RecordStatus recordStatus, Patients patient) {
        this.disease = disease;
        this.recordType = recordType;
        this.severity = severity;
        this.recordStatus = recordStatus;
        this.patient = patient;
        System.out.println("Medical Record created for patient " +
                            patient.getPatName() + " " + patient.getPatSurname());
        severity.processSeverity();
        recordType.processRecord();
        System.out.println(recordStatus);
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Medical Record" +
                recordType +
                " created for patient " + patient +
                " with " + disease +
                " recordStatus is " + recordStatus +
                '}';
    }
}
