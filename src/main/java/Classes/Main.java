package Classes;

import Exceptions.InvalidAddressException;
import Exceptions.InvalidCountryException;
import Exceptions.InvalidSalaryInput;
import Exceptions.NonMedicalSalaryException;
import enums.Disease;
import enums.DrugType;
import enums.StaffType;

import java.util.LinkedList;


public class Main {
//    Interfaces were renamed
//    created saveToFile method writing drug object toString() to .txt file. Used try-catch with resources.
//    created custom exceptions InvalidAddressException (not null)
//    InvalidCountryException (only Poland)
//    InvalidSalaryInput (1 > doctorsCategory < 6)
//    NonMedicalSalaryException (standard salary > 50)
//    added pom.xml and downloaded log4j 2 with maven
//    logger works
//    created MyLinkedList and work with it creating drugList
//    added childPatList<> and static returnAllChildPat() to ChildPatient class
//    added oldPatList<> as a Set collection and returnAllOldPatients()



    public static void main(String[] args) throws InvalidAddressException, InvalidCountryException, InvalidSalaryInput, NonMedicalSalaryException {

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

//        working with regionalHospital class
        RegionalHospitalInformation regionalHospital1 = new RegionalHospitalInformation("Warsaw centrum hospital", address1, "the Warsaw centrum");
        System.out.println(regionalHospital1);

//        working with EmergencyHospital class
        EmergencyHospitalInformation emergencyHospital1 = new EmergencyHospitalInformation("Main Emergency service", address1, 17);
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
        Dentistry dent1 = new Dentistry("Warsaw dentistry", address1, 300);
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
        ChildPatient.returnAllChildPat();

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
    }
}
