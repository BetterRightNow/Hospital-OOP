package com.solvd.laba.enums;

public enum RecordStatus {
    OPEN ("opened"),
    CLOSED ("closed"),
    PENDING("pending");
    private String status;

    RecordStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Record Status is " + status;
    }
}
