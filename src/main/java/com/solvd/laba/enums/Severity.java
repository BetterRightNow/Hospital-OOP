package com.solvd.laba.enums;

import com.solvd.laba.Classes.Patients;

public enum Severity {
    MILD {
        @Override
        public void processSeverity(){
            System.out.println("the patient can be discharged in a week");
        }
    },
    MODERATE{
        @Override
        public void processSeverity(){
            System.out.println("the patient needs to be closely monitored");
        }
    },
    SEVERE{
        @Override
        public void processSeverity(){
            System.out.println("the patient must be admitted to the intensive care unit");
        }
    };

    public void processSeverity(){};
}
