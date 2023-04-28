package Classes;

import Exceptions.NonMedicalSalaryException;
import Interfaces.SalaryCalculator;
import enums.StaffType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class NonMedicalStaff extends Staff implements SalaryCalculator {
    public Logger nonMedicalSalaryLogger = LogManager.getLogger();
    private StaffType staffType;
    private int staffCategory;
    private int standardSalary;

    public NonMedicalStaff(String name, String surname, StaffType staffType, int staffCategory, int standardSalary) throws NonMedicalSalaryException {
        super(name, surname);
        Configurator.initialize(null,"log4j2.xml");
        nonMedicalSalaryLogger.info("application started");
        if (standardSalary < 50) {
            nonMedicalSalaryLogger.error("Invalid standard salary input");
            throw new NonMedicalSalaryException("Standard salary of non medical staff should be more than 50$");
        }
        this.staffType = staffType;
        this.staffCategory = staffCategory;
        this.standardSalary = standardSalary;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public int getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(int staffCategory) {
        this.staffCategory = staffCategory;
    }

    public int getStandardSalary() {
        return standardSalary;
    }

    public void setStandardSalary(int standardSalary) {
        this.standardSalary = standardSalary;
    }

    @Override
    public void calculatePayment() {
        int payment = standardSalary * staffCategory;
        System.out.println("Salary is " + payment + "$");
    }

    @Override
    public String toString () {
        return "\nName" + getName() +
                " surname " + getSurname() +
                " working area " + staffType;
    }
}
