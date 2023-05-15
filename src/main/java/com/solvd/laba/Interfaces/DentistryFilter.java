package com.solvd.laba.Interfaces;

import com.solvd.laba.Classes.Patients;
@FunctionalInterface
public interface DentistryFilter {
    boolean filter(Patients patient);
}
