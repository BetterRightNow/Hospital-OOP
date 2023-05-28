package com.solvd.laba.enums;

import com.solvd.laba.classes.Operations;
import com.solvd.laba.classes.Patients;

public enum OperationType {
    SURGERY {
        public void operationSchedule(Patients patient) {
            Operations operation1 = new Operations(SURGERY, patient);
            System.out.println(operation1);
        }
    },
    ORTHOPEDIC_SURGERY {
        @Override
        public void operationSchedule(Patients patient) {
            Operations operation2 = new Operations(ORTHOPEDIC_SURGERY, patient);
            System.out.println(operation2);
        }
    },
    CARDIOVASCULAR_SURGERY {
        @Override
        public void operationSchedule(Patients patient) {
            Operations operation3 = new Operations(CARDIOVASCULAR_SURGERY, patient);
            System.out.println(operation3);
        }
    },
    NEUROSURGERY {
        @Override
        public void operationSchedule(Patients patient) {
            Operations operation4 = new Operations(NEUROSURGERY, patient);
            System.out.println(operation4);
        }
    },
    LAPAROSCOPIC_SURGERY  {
        @Override
        public void operationSchedule(Patients patient) {
            Operations operation5 = new Operations(LAPAROSCOPIC_SURGERY, patient);
            System.out.println(operation5);
        }
    };
    public void operationSchedule(Patients patient) {};
    static {
        System.out.println("Attention, medical operations occur");
    }
}
