package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidAddressException;
import com.solvd.laba.Exceptions.InvalidCountryException;
import com.solvd.laba.Exceptions.InvalidSalaryInput;
import com.solvd.laba.Exceptions.NonMedicalSalaryException;
import com.solvd.laba.enums.*;

import java.io.IOException;
import java.util.function.Predicate;


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
//    Consumer<String> hurricane in PrivateClinic
//    Function<> in RegionalHospital
//    Consumer<Queue<Patients>> in Dentistry class
//    Function <> in PrivateClinic class
//    custom Ambulance<> in EmergencyHospital class
//    custom CheckDentistry<> in Dentistry class
//    custom NurseRetirement<> in Nurses class



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
        System.out.println(hospice1.isLarge(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (hospice1.getMaxPatientsNum() > 50) {
                    return true;
                }
                return false;
            }
        }));


//        working with Doctors class
        Doctors doc1 = new Doctors("Robert", "Lewandowski", "Dentistry", 2, 500);
        System.out.println(doc1);
        doc1.calculatePayment();
        doc1.alert();

//        working with Nurses class
        Nurses nurse1 = new Nurses("Eliza", "Kowalska", 4, 300);
        System.out.println(nurse1);
        nurse1.calculatePayment();
        System.out.println(nurse1.calculateYearlySalary());

//        working with Dentistry class
        Dentistry dent1 = new Dentistry("Warsaw dentistry", address1, 300, 10);
        System.out.println(dent1);


//        working with nonMedicalStaff
        NonMedicalStaff driver1 = new NonMedicalStaff("John", "Doe", StaffType.DRIVER, 2, 200);
        System.out.println(driver1);
        driver1.calculatePayment();
        StaffType driver = driver1.getStaffType();
        driver.vacation();


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
        System.out.println("\nworking with Consumer Queue");
        dent1.filterPatients();

//        Working with privateClinicQueue collection
        System.out.println("\nWorking with privateClinicQueue collection");
        privateClinic1.addPatient(oldPatient1);
        privateClinic1.addPatient(oldPatient2);
        privateClinic1.addPatient(childPatient1);
        System.out.println(privateClinic1.nextPatient());
        System.out.println("\nWorking with Function<> lambda function");
        privateClinic1.choosePatients();


//        Working with TextCount class
        System.out.println("\nWorking with TextCount class");
        TextCount.textCount("src/main/resources/hospitalText.txt");

//        Working with UniqueWordsCount class
        UniqueWordsCount.countUniqueWords("src/main/resources/words.txt");

//        Operations class and OperationType enum
        System.out.println("\nworking with Operations class");
        OperationType.SURGERY.operationSchedule(oldPatient4);

//        working with medical records
        System.out.println("\nworking with medical records");
        MedicalRecords medicalRecord = new MedicalRecords(Disease.ANGINA, RecordType.MEDICAL_HISTORY, Severity.MODERATE, RecordStatus.OPEN, childPatient2);

//        working with Supplier<> exampleEmergObj
        System.out.println("\nworking with Supplier<> in EmergencyHospital class");
        System.out.println(EmergencyHospital.exampleEmergObj.get());

//        working with Ambulance<> in EmergencyHospital class
        System.out.println("\nworking with Ambulance<> in EmergencyHospital class");
        System.out.println(emergencyHospital1.ambulanceTeam());

//        working with CheckDentistry<> in Dentistry class
        System.out.println("\nworking with CheckDentistry<> in Dentistry class");
        dent1.checkQueue();

//        working with NurseRetirement<> in Nurses class
        System.out.println("\nworking with NurseRetirement<> in Nurses class");
        System.out.println("nurse " + nurse1.getName() + " has " + nurse1.nurseRetirement() + " years till retirement");

//        working with dentistryFilter lambda
        System.out.println("\nworking with dentistryFilter lambda");
        System.out.println("in dentistry " + dent1.getName() + " there are such patients with angina " + dent1.filterDentQueue(patient -> {
            if (patient.getDisease() == Disease.ANGINA) {
                return true;
            }
            return false;
        }));
    }
}
