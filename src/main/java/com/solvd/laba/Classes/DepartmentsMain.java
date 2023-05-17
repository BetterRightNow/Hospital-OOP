package com.solvd.laba.Classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentsMain {
    public static void main(String[] args) {

//        initializing the Logger
        Logger departmentsLogger = LogManager.getLogger();
        Configurator.initialize(null, "log4j2.xml");


//        creating SurgicalDepartment object
        SurgicalDepartment surgicalDepartment1 =
                new SurgicalDepartment("Warsaw surgical department", 7);

//        adding Doctors objects to surgeons list
        surgicalDepartment1.addSurgeons(new Doctors("Ivan", "Ivanov",
                "Surgery", 4, 200));
        surgicalDepartment1.addSurgeons(new Doctors("Piotr", "Pietrov",
                "Surgery", 3, 150));
        surgicalDepartment1.addSurgeons(new Doctors("Pavel", "Pavlov",
                "Surgery", 5, 250));
        surgicalDepartment1.addSurgeons(new Doctors("Zahar", "Zaharov",
                "Surgery", 1, 100));
        surgicalDepartment1.addSurgeons(new Doctors("Maria", "Kuznetsova",
                "Surgery", 3, 400));

//        working with non-terminal stream method filter
        List<Doctors> filteredDoctors = surgicalDepartment1.returnSurgeons().stream().
                filter(doctor -> (doctor.getDoctorsCategory() == 3)).collect(Collectors.toList());
        departmentsLogger.info(filteredDoctors);

    }
}
