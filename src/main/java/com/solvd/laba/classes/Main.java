package com.solvd.laba.classes;

import com.solvd.laba.exceptions.InvalidAddressException;
import com.solvd.laba.exceptions.InvalidCountryException;
import com.solvd.laba.exceptions.InvalidSalaryInput;
import com.solvd.laba.exceptions.NonMedicalSalaryException;
import com.solvd.laba.enums.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
//    created TextCount class that works with static textCount method
//    changed extensions of custom exceptions
//    created UniqueWordsCount class and countUniqueWords method
//    Enum StaffType have vacation() method, int vacation field, toString()
//    Operations class and OperationType enum. operationSchedule() creates an object of Operations
//    created MedicalRecords class working with enums
//    Severity enum overrides processSeverity()
//    RecordStatus enum contains String status field and toString()
//    RecordType enum contains String recordReport field and processRecord()

//    filterDentQueue method with interface and lambda function
//    created Predicate<Integer> isLarge in Hospice Class
//    created Supplier<EmergencyHospital> exampleEmergObj
//    created UnaryOperator<Integer> yearSalaryLambda in Nurses class
//    Consumer<Queue<Patients>> in Dentistry class
//    Function <> in PrivateClinic class
//    custom PrintTeam<> in EmergencyHospital class
//    custom CheckDentistry<> in Dentistry class
//    created CheckOldness<> in PrivateClinic class

//    Consumer<String> hurricane in PrivateClinic
//    Function<> in RegionalHospital



    public static void main(String[] args) throws InvalidAddressException, InvalidCountryException, InvalidSalaryInput, NonMedicalSalaryException, IOException {

//        working with address class
        Address address1 = new Address("Poland", "Warsaw", "Marshalkovska", 1);
        System.out.println(address1);
        Address address2 = new Address("Poland", "Krakow", "Krola",3);
        Address address3 = new Address("Poland", "Wroclaw", "Jadwigi",7);
        Address address4 = new Address("Poland", "Gdansk", "Mieszko",77);
        Address address5 = new Address("Poland", "Szczecin", "Kazimira",7);
        Address address6 = new Address("Poland", "Jasna Gora", "Konrada",41);

//        working with privateClinic class
        PrivateClinic privateClinic1 = new PrivateClinic("First private Clinic", address1, "Luxmed");
        System.out.println(privateClinic1);
        privateClinic1.destroy();

//        working with regionalHospital class
        RegionalHospital regionalHospital1 = new RegionalHospital("Warsaw centrum hospital", address1, "the Warsaw centrum");
        System.out.println(regionalHospital1);
        regionalHospital1.regionReport();

//        working with EmergencyHospital class
        EmergencyHospital emergencyHospital1 = new EmergencyHospital("Main Emergency service", address1, 17);
        System.out.println(emergencyHospital1);

//        working with Hospice class
        Hospice hospice1 = new Hospice("Polish main Hospice", address1, 202);
        System.out.println(hospice1);

//        working with Doctors class
        Doctors doc1 = new Doctors("Robert", "Lewandowski", "Dentistry", 2, 500);
        System.out.println(doc1);
        doc1.calculatePayment();
        doc1.alert();

//        working with Nurses class
        Nurses nurse1 = new Nurses("Eliza", "Kowalska", 4, 300);
        System.out.println(nurse1);
        nurse1.calculatePayment();

//        working with Dentistry class
        Dentistry dent1 = new Dentistry("Warsaw dentistry", address1, 300, 10);
        System.out.println(dent1);


//        working with nonMedicalStaff
        NonMedicalStaff driver1 = new NonMedicalStaff("John", "Doe", StaffType.DRIVER, 2, 200);
        System.out.println(driver1);
        driver1.calculatePayment();


//        working with Drugs Class
        Drugs drug1 = new Drugs("Penicillin", "14 days, 2 times every day", DrugType.ANTIBIOTIC);
        Drugs drug2 = new Drugs("Aspirin", "3 days, once a day", DrugType.NON_PRESCRIPTION);
        Drugs drug3 = new Drugs("Vitamin C", "30 days, 3 times every day", DrugType.VITAMIN);
        Drugs drug4 = new Drugs("Sulfasalazine", "45 days, 6 times every day", DrugType.PRESCRIPTION);
        System.out.println(drug1);
        System.out.println(drug2);
        System.out.println(drug3);
        System.out.println(drug4);
        Drugs.drugCount();
        drug4.saveToFile("drugList.txt");
        MyLinkedList <Drugs> druglist = new MyLinkedList<>();
        druglist.add(drug1);
        druglist.add(drug2);
        druglist.add(drug3);
        druglist.add(drug2);
        druglist.remove(drug2);
        System.out.println("\nWorking with MyLinkedList");
        for (int i = 0; i < druglist.size(); i++) {
            System.out.println(druglist.get(i));
        }

//        working with class ChildPatient
        ChildPatient childPatient1 = new ChildPatient("Piotr", "Ivanov", Disease.FLU, address2, "Kate");
        childPatient1.prescribeDrug(childPatient1.getDisease(), drug2);
        ChildPatient childPatient2 = new ChildPatient("Jan", "Zrajkowski", Disease.COLDS, address3,"Karol");
        childPatient2.prescribeDrug(childPatient1.getDisease(), drug4);
        childPatient2.inspect(childPatient2.getDisease());
        childPatient2.transport(emergencyHospital1);
        childPatient2.admit(emergencyHospital1);
        System.out.println("\nworking with childPatList collection");
        ChildPatient.returnAllChildPat();
        System.out.println("\nworking with childPatMap collection");
        ChildPatient.returnPatMap();

//        working with class OldPatient
        OldPatient oldPatient1 = new OldPatient("Marek", "Sobeski", Disease.ANGINA, address4,"Pawel");
        oldPatient1.prescribeDrug(oldPatient1.getDisease(), drug1);
        OldPatient oldPatient2 = new OldPatient("Inna", "Kuzmina", Disease.ANGINA, address5,"Alex");
        oldPatient2.prescribeDrug(oldPatient2.getDisease(), drug1);
        OldPatient oldPatient3 = new OldPatient("Sergey", "Ivanov", Disease.HEALTHY_PATIENT, address6,"Piotr");
        OldPatient oldPatient4 = new OldPatient("Inna", "Kuzmina", Disease.ANGINA, address5,"Alex");
        oldPatient3.inspect(oldPatient3.getDisease());
        oldPatient1.transport(regionalHospital1);
        oldPatient1.admit(regionalHospital1);
        System.out.println("\nworking with setList oldPatList and checking working with duplicating OldPatient objects");
        OldPatient.returnAllOldPatients();

//        Working with dentistryQueue collection
        System.out.println("\nWorking with dentistryQueue collection");
        dent1.addPatient(childPatient2);
        dent1.addPatient(oldPatient2);
        dent1.addPatient(childPatient1);
        System.out.println(dent1.removeAndReturnPatient());

//        Working with privateClinicQueue collection
        System.out.println("\nWorking with privateClinicQueue collection");
        privateClinic1.addPatient(oldPatient1);
        privateClinic1.addPatient(oldPatient2);
        privateClinic1.addPatient(childPatient1);
        System.out.println(privateClinic1.nextPatient());

//        Working with TextCount class
        System.out.println("\nWorking with TextCount class");
        TextCount.textCount("src/main/resources/hospitalText.txt");

//        Working with UniqueWordsCount class
        UniqueWordsCount.countUniqueWords("src/main/resources/words.txt");

//        working with vacation() method in Enum StaffType
        System.out.println("\nworking with vacation() method in Enum StaffType");
        StaffType driver = driver1.getStaffType();
        driver.vacation();


//        Operations class and OperationType enum
        System.out.println("\nworking with Operations class");
        OperationType.SURGERY.operationSchedule(oldPatient4);

//        working with medical records
        System.out.println("\nworking with medical records");
        MedicalRecords medicalRecord = new MedicalRecords(Disease.ANGINA, RecordType.MEDICAL_HISTORY, Severity.MODERATE, RecordStatus.OPEN, childPatient2);

//        working with dentistryFilter lambda
        System.out.println("\nworking with dentistryFilter lambda");
        System.out.println("in dentistry " + dent1.getName() + " there are such patients with angina " + dent1.filterDentQueue(patient -> patient.getDisease() == Disease.ANGINA));

//        working Predicate<Integer> isLarge in Hospice Class
        System.out.println("\nworking Predicate<Integer> isLarge in Hospice Class");
        hospice1.isLarge((integer) -> hospice1.getMaxPatientsNum() > 50);

//        working with Supplier<> exampleEmergObj in EmergencyHospital class
        System.out.println("\nworking with Supplier<> in EmergencyHospital class");
        EmergencyHospital.createExampleObj(() -> new EmergencyHospital("ExampleName", new Address("Poland", "Warsaw", "ExampleStreet", 77), 99));

//        working with UnaryOperator<> in Nurses class
        System.out.println("\nworking with UnaryOperator<> in Nurses class");
        System.out.println("Nurse " + nurse1.getName() + " have " +
                nurse1.nurseRetirement((integer) -> 40 - nurse1.getExperience()) +
                " years till retirement");

//        working with Consumer<Queue<Patients>> in Dentistry class
        System.out.println("\nworking with Consumer<Queue<Patients>> in Dentistry class");
        dent1.filterPatients((patient) -> {
            if (patient.getAddress().getCity().equals("Krakow")) {
                System.out.println(patient);
            }
        });

//        working with Function<> in PrivateClinic class
        System.out.println("\nWorking with Function<> in PrivateClinic class");
        privateClinic1.choosePatients(privateClinic -> {
            List<Patients> chosenPatients = new ArrayList<>();
            for (Patients p: privateClinic1.getPrivateClinicQueue()) {
                if (p.getDisease() == Disease.ANGINA) {
                    chosenPatients.add(p);
                }
            }
            return chosenPatients;
        });

//        working with Ambulance<> in EmergencyHospital class
        System.out.println("\nworking with PrintTeam<> in EmergencyHospital class");
        emergencyHospital1.ambulanceTeam(hospital -> {
            return "The ambulance team of " + emergencyHospital1.getName() +
                    " consists of " + emergencyHospital1.getAmbulancesNum() + " drivers, "
                    + emergencyHospital1.getAmbulancesNum() + " doctors and " +
                    (emergencyHospital1.getAmbulancesNum() * 2) + " nurses";
        });

//        working with CheckDentistry<> in Dentistry class
        System.out.println("\nworking with CheckDentistry<> in Dentistry class");
        dent1.checkQueue((dentQueue) -> {
            if (dent1.getDentistryQueue().size() < dent1.getMaxPatientsInQueue()) {
                System.out.println("queue of  " + dent1.getName() +
                        " is ok, number of free places is " +
                        (dent1.getMaxPatientsInQueue() - dent1.getDentistryQueue().size()));
            } else {
                System.out.println("queue of  " + dent1.getName() + "is overcrowded");
            }
        });

//        working with CheckOldness<> in PrivateClinic class
        System.out.println("\n working with CheckOldness<> in PrivateClinic class");
        List<Patients> oldCollection = new ArrayList<>();
        privateClinic1.checkOldPatients((clinic, patients, collection) -> {
            for (Patients p : patients) {
                if (p instanceof OldPatient) {
                    oldCollection.add(p);
                }
            }
        }, oldCollection);
        System.out.println(oldCollection);

    }
}
