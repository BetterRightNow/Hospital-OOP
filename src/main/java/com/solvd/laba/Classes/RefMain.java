package com.solvd.laba.Classes;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;

public class RefMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {

        Logger refLogger = LogManager.getLogger();
        Configurator.initialize(null, "log4j2.xml");

        Class surgicalClass = Class.forName("com.solvd.laba.Classes.SurgicalDepartment");

//        all methods of SurgicalDepartment class
        List<String> methodNames = Stream.of(surgicalClass.getMethods()).map(Method::getName).toList();

//        declared methods of SurgicalDepartment class
        List<String> declaredMethodNames = Stream.of(surgicalClass.getDeclaredMethods()).
                map(Method::getName).toList();

//        working with setAvailableOperatingRooms method of SurgicalDepartment class
        SurgicalDepartment surgDep1 = new SurgicalDepartment("surgDep1", 12);
        Method setDep = surgicalClass.getDeclaredMethod("setAvailableOperatingRooms", int.class);
        setDep.invoke(surgDep1, 10);

        SurgicalDepartment surgicalObj = (SurgicalDepartment)
                surgicalClass.getDeclaredConstructor(String.class, int.class).
                newInstance("testSurgObj", 3);


        refLogger.info("\nall methods of SurgicalDepartment class\n" + methodNames +
                "\n\ndeclared methods of SurgicalDepartment class\n" + declaredMethodNames +
                "\n\nworking with setAvailableOperatingRooms method of SurgicalDepartment class\n" + surgDep1 +
                "\n\ncreating new testSurgObj object of SurgicalDepartment class\n" + surgicalObj + "\n");



//        changing the availableOperatingRooms value of field SurgicalDepartment class
        Field operationField = surgicalClass.getDeclaredField("availableOperatingRooms");
        operationField.setAccessible(true);
        operationField.set(surgDep1, 20);

        refLogger.info("\n\nchanging the availableOperatingRooms value of field SurgicalDepartment class\n" +
                surgDep1);
    }
}
