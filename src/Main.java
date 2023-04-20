public class Main {

//    constructors moved to the beginning of classes, before getters and setters
//    printInfo methods are replaced with overriding toString of each class

    public static void main(String[] args) {

//        working with address class
        Address address1 = new Address("Poland", "Warsaw", "Marshalkovska", 1);
        System.out.println(address1);

//        working with class Hospital class
        Hospital hospital1 = new Hospital("Warsaw Hospital for Children", address1);
        System.out.println(hospital1);

//        working with privateClinic class
        PrivateClinic privateClinic1 = new PrivateClinic("First private Clinic", address1, "Luxmed");
        System.out.println(privateClinic1);

//        working with regionalHospital class
        RegionalHospital regionalHospital1 = new RegionalHospital("Warsaw centrum Hospital", address1, "the Warsaw centrum");
        System.out.println(regionalHospital1);

//        working with EmergencyHospital class
        EmergencyHospital emergencyHospital1 = new EmergencyHospital("Main Emergency service", address1, 17);
        System.out.println(emergencyHospital1);

//        working with Hospice class
        Hospice hospice1 = new Hospice("Polish main Hospice", address1, 202);
        System.out.println(hospice1);

//        working with Dentistry class
        Dentistry dent1 = new Dentistry("Warsaw dentistry", address1, 300);
        System.out.println(dent1);

//        working with Staff class
        Staff employee1 = new Staff("Robert", "kowalski");
        System.out.println(employee1);

//        working with Doctors class
        Doctors doc1 = new Doctors("Robert", "Lewandowski", "Dentistry");
        System.out.println(doc1);

//        working with Nurses class
        Nurses nurse1 = new Nurses("Eliza", "Kowalska", 4);
        System.out.println(nurse1);

//        working with nonMedicalStaff
        NonMedicalStaff driver1 = new NonMedicalStaff("John", "Doe", "Driver");
        System.out.println(driver1);

//        working with Disease class
        Disease disease1 = new Disease("Cold");
        System.out.println(disease1);

//        working with Drugs Class
        Drugs drug1 = new Drugs("Penicillin", true);
        Drugs drug2 = new Drugs("Aspirin", false);
        System.out.println(drug1);
        System.out.println(drug2);

//        working with Antibiotic class
        Antibiotic ant1 = new Antibiotic("amoxicillin", true, "3 days, 3 time per day");
        Antibiotic ant2 = new Antibiotic("doxycycline", false, "7 days, 1 time per day");
        System.out.println(ant1);
        System.out.println(ant2);

//        working with NonAntibiotic class
        NonAntibiotic nonAnt1 = new NonAntibiotic("vitamins A", false, "30 days, 3 time per day");
        NonAntibiotic nonAnt2 = new NonAntibiotic("vitamins с", true, "1 days, 1 time per day");
        System.out.println(nonAnt1);
        System.out.println(nonAnt2);
    }
}
