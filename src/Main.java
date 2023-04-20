public class Main {
    //    constructors moved to the beginning of classes, before getters and setters
    public static void main(String[] args) {

//        working with address class
        Address address1 = new Address("Poland", "Warsaw", "Marshalkovska", 1);
        address1.printAddress();

//        working with class Hospital class
        Hospital hospital1 = new Hospital("Warsaw Hospital for Children", address1);
        hospital1.printHospitalDetails();

//        working with privateClinic class
        PrivateClinic privateClinic1 = new PrivateClinic("First private Clinic", address1, "Luxmed");
        privateClinic1.printPrivateClinicDetails();

//        working with regionalHospital class
        RegionalHospital regionalHospital1 = new RegionalHospital("Warsaw centrum Hospital", address1, "the Warsaw centrum");
        regionalHospital1.printRegionalHospitalDetails();

//        working with EmergencyHospital class
        EmergencyHospital emergencyHospital1 = new EmergencyHospital("Main Emergency service", address1, 17);
        emergencyHospital1.printEmergHospInfo();

//        working with Staff class
        Staff employee1 = new Staff("Robert", "kowalski");
        employee1.printStafInfo();

//        working with Doctors class
        Doctors doc1 = new Doctors("Robert", "Lewandowski", "Dentistry");
        doc1.printDoctorDetails();

//        working with Nurses class
        Nurses nurse1 = new Nurses("Eliza", "Kowalska", 4);
        nurse1.printNurseInfo();

//        working with nonMedicalStaff
        NonMedicalStaff driver1 = new NonMedicalStaff("John", "Doe", "Driver");
        driver1.printNonMedicInfo();

//        working with Disease class
        Disease disease1 = new Disease("Cold");
        disease1.printDiseaseInfo();

//        working with Drugs Class
        Drugs drug1 = new Drugs("Penicillin", true);
        Drugs drug2 = new Drugs("Aspirin", false);
        drug1.printDrugInfo();
        drug2.printDrugInfo();

//        working with Antibiotic class
        Antibiotic ant1 = new Antibiotic("amoxicillin", true, "3 days, 3 time per day");
        Antibiotic ant2 = new Antibiotic("doxycycline", false, "7 days, 1 time per day");
        ant1.printAntibioticInfo();
        ant2.printAntibioticInfo();

//        working with NonAntibiotic class
        NonAntibiotic nonAnt1 = new NonAntibiotic("vitamins A", false, "30 days, 3 time per day");
        NonAntibiotic nonAnt2 = new NonAntibiotic("vitamins с", true, "1 days, 1 time per day");
        nonAnt1.printNonAntibioticInfo();
        nonAnt2.printNonAntibioticInfo();

//        working with Hospice class
        Hospice hospice1 = new Hospice("Polish main Hospice", address1, 202);
        hospice1.printHospiceInfo();

//        working with Dentistry class
        Dentistry dent1 = new Dentistry("Warsaw dentistry", address1, 300);
        dent1.printDentistryInfo();
    }
}
