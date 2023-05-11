package com.solvd.laba.enums;

public enum RecordType {
    MEDICAL_HISTORY ("Medical history created"),
    TEST_RESULTS ("Test results created"),
    PRESCRIPTION ("Prescription created");

    private String recordReport;

    RecordType(String recordReport) {
        this.recordReport = recordReport;
    }

    public String getRecordReport() {
        return recordReport;
    }

    public void setRecordReport(String recordReport) {
        this.recordReport = recordReport;
    }

    public void processRecord () {
        System.out.println(recordReport);
    }
}
