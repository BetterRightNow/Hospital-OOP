package com.solvd.laba.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class DepartmentsMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

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
                filter(doctor -> (doctor.getDoctorsCategory() == 3)).toList();

//        working with non-terminal stream method map
        List<Integer> doctorsStandardSalaryCollection = surgicalDepartment1.returnSurgeons().
                stream().map(Doctors::getStandardSalary).toList();

//        working with non-terminal stream method mapToInt
        double avgStandardSalary = surgicalDepartment1.returnSurgeons().
                stream().mapToInt(Doctors::getStandardSalary).average().getAsDouble();

//        working with non-terminal stream method sorted
        List<Doctors> sortedDoctors =  surgicalDepartment1.returnSurgeons().
                stream().sorted(Comparator.comparingInt(Doctors::getDoctorsCategory)).toList();

//        working with terminal stream method count
        long doctorsNum = surgicalDepartment1.returnSurgeons().
                stream().count();

//        working with terminal stream method forEach
        surgicalDepartment1.returnSurgeons().
                stream().forEach(System.out::println);

//        working with terminal stream method reduce
        String surnames = surgicalDepartment1.returnSurgeons().stream().
                map(Doctors::getSurname).reduce((a , b) -> a + ", " + b).orElse("");

//        logger output
        departmentsLogger.info(
                "\nworking with non-terminal stream method filter\n" + filteredDoctors +
                "\n\nworking with non-terminal stream method map\n" + doctorsStandardSalaryCollection +
                "\n\nworking with non-terminal stream method mapToInt\n" + avgStandardSalary +
                "\n\nworking with non-terminal stream method sorted\n" + sortedDoctors +
                "\n\nworking with terminal stream method count\n" + doctorsNum +
                "\n\nworking with terminal stream method reduce\n" + surnames);


//        working with Reflection

        Class surgicalClass = Class.forName("com.solvd.laba.classes.SurgicalDepartment");

        //        all methods of SurgicalDepartment class
        List<String> methodNames = Stream.of(surgicalClass.getMethods()).map(Method::getName).toList();

//        declared methods of SurgicalDepartment class
        List<String> declaredMethodNames = Stream.of(surgicalClass.getDeclaredMethods()).
                map(Method::getName).toList();

//        working with setAvailableOperatingRooms method of SurgicalDepartment class
        SurgicalDepartment surgDep1 = new SurgicalDepartment("surgDep1", 12);
        Method setDep = surgicalClass.getDeclaredMethod("setAvailableOperatingRooms", int.class);
        setDep.invoke(surgDep1, 10);

//        creating new testSurgObj object of SurgicalDepartment class
        SurgicalDepartment surgicalObj = (SurgicalDepartment)
                surgicalClass.getDeclaredConstructor(String.class, int.class).
                        newInstance("testSurgObj", 3);


        departmentsLogger.info("\n\nall methods of SurgicalDepartment class\n" + methodNames +
                "\n\ndeclared methods of SurgicalDepartment class\n" + declaredMethodNames +
                "\n\nworking with setAvailableOperatingRooms method of SurgicalDepartment class\n" + surgDep1 +
                "\n\ncreating new testSurgObj object of SurgicalDepartment class\n" + surgicalObj + "\n");



//        changing the availableOperatingRooms value of field SurgicalDepartment class
        Field operationField = surgicalClass.getDeclaredField("availableOperatingRooms");
        operationField.setAccessible(true);
        operationField.set(surgDep1, 20);

        departmentsLogger.info("\n\nchanging the availableOperatingRooms " +
                "value of field SurgicalDepartment class\n" + surgDep1);
    }
}
