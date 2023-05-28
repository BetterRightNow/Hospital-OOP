package com.solvd.laba.interfaces;

import com.solvd.laba.classes.Patients;
@FunctionalInterface
public interface DentistryFilter {
    boolean filter(Patients patient);
}
