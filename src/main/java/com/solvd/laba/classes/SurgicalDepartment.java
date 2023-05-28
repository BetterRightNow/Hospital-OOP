package com.solvd.laba.classes;

import java.util.ArrayList;
import java.util.List;

public class SurgicalDepartment extends Departments{
    private int availableOperatingRooms;
    private List<Doctors> surgeons = new ArrayList<>();

    public SurgicalDepartment(String departmentName, int availableOperatingRooms) {
        super(departmentName);
        this.availableOperatingRooms = availableOperatingRooms;
    }

    public void setAvailableOperatingRooms(int availableOperatingRooms) {
        this.availableOperatingRooms = availableOperatingRooms;
    }

    public void addSurgeons (Doctors doctor) {
        surgeons.add(doctor);
    }
    public List<Doctors> returnSurgeons () {
        return surgeons;
    }

    @Override
    public String toString() {
        return "SurgicalDepartment{" +
                "availableOperatingRooms=" + availableOperatingRooms +
                '}';
    }
}
